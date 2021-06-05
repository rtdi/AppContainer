package io.rtdi.appcontainer.rest.odata.table;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.EdmElement;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmPrimitiveType;
import org.apache.olingo.commons.api.edm.EdmProperty;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataLibraryException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.PrimitiveProcessor;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.PrimitiveSerializerOptions;
import org.apache.olingo.server.api.serializer.SerializerException;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriParameter;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.apache.olingo.server.api.uri.UriResourceProperty;

import io.rtdi.appcontainer.rest.odata.ODataUtils;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public class ODataPrimitiveProcessor implements PrimitiveProcessor {
	private OData odata;
	private ServiceMetadata serviceMetadata;
	private Connection conn;
	private String schemaname;
	private String viewname;

	public ODataPrimitiveProcessor(Connection conn, String schemaname, String viewname) {
		this.conn = conn;
		this.schemaname = schemaname;
		this.viewname = viewname;
	}

	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;
	}

	@Override
	public void readPrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType responseFormat)
			throws ODataApplicationException, SerializerException {
		try {
			// 1. Retrieve info from URI
			// 1.1. retrieve the info about the requested entity set
			List<UriResource> resourceParts = uriInfo.getUriResourceParts();
			// Note: only in our example we can rely that the first segment is the EntitySet
			UriResourceEntitySet uriEntityset = (UriResourceEntitySet) resourceParts.get(0);
			EdmEntitySet edmEntitySet = uriEntityset.getEntitySet();
			// the key for the entity
			List<UriParameter> keyPredicates = uriEntityset.getKeyPredicates();
	
			// 1.2. retrieve the requested (Edm) property
			// the last segment is the Property
			UriResourceProperty uriProperty = (UriResourceProperty) resourceParts.get(resourceParts.size() -1);
			EdmProperty edmProperty = uriProperty.getProperty();
			String edmPropertyName = edmProperty.getName();
			// in our example, we know we have only primitive types in our model
			EdmPrimitiveType edmPropertyType = (EdmPrimitiveType) edmProperty.getType();
	
			// 2. retrieve data from backend
			// 2.1. retrieve the entity data, for which the property has to be read
			Entity row = null;
			
			StringBuilder sql = new StringBuilder("select * from \"" + schemaname + "\".\"" + viewname + "\"");
			boolean first = true;
			for ( UriParameter k : keyPredicates) {
				/*
				 * A filter on the surrogate ODataEdm.ROWNUM column is not part of the SQL where clause
				 */
				if (!k.getName().equals(ODataEdm.ROWNUM)) {
					if (first) {
						first = false;
						sql.append(" where ");
					} else {
						sql.append("AND ");
					}
					sql.append("\"" + k.getName() + "\" = ? ");
				}
			}
		    EdmEntityType entityType = edmEntitySet.getEntityType();
			try (PreparedStatement stmt = conn.prepareStatement(sql.toString());) {
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
				String id = "";
				Integer rownumfilter = null; // return only the n-th row in the result set
				for ( int i=0; i<keyPredicates.size(); i++) {
					UriParameter k = keyPredicates.get(i);
					EdmElement property = entityType.getProperty(k.getName());
					JDBCType jdbcdatatype = ODataUtils.getJDBCDataType(property.getType());
					String value = k.getText();
					try {
						if (!k.getName().equals(ODataEdm.ROWNUM)) {
							switch (jdbcdatatype) {
							case BINARY:
							case BLOB:
							case CHAR:
							case CLOB:
							case NCHAR:
							case NCLOB:
							case NVARCHAR:
							case VARBINARY:
							case VARCHAR:
								stmt.setString(i+1, value.substring(1, value.length()-1)); // trim leading ' chars
								break;
							case BIGINT:
							case DECIMAL:
							case DOUBLE:
							case INTEGER:
							case REAL:
							case SMALLINT:
							case TINYINT:
								stmt.setString(i+1, value);
								break;
							case BOOLEAN:
								stmt.setBoolean(i+1, value.equalsIgnoreCase("true"));
								break;
							case DATE: // 2010-01-01
								Date date = Date.valueOf(value);
								stmt.setDate(i+1, date );
								break;
							case TIME: // 10:00:00
								Time time = Time.valueOf(value);
								stmt.setTime(i+1, time);
								break;
							case TIMESTAMP:
								Instant utc = Instant.parse(value);
								Timestamp ts = Timestamp.from(utc);
								stmt.setTimestamp(i+1, ts, cal);
								break;
							default:
								stmt.setString(i+1, value.substring(1, value.length()-1)); // trim leading ' chars
								break;
							}
							if (id.length() != 0) {
								id += ".";
							}
							id += k.getText();
						} else {
							rownumfilter = Integer.valueOf(value);
						}
					} catch (NumberFormatException | DateTimeParseException e) {
						throw new AppContainerSQLException(e, sql.toString(), "Cannot convert the key \"" + value + "\" to the native data type");
					}
				}
				try (ResultSet rs = stmt.executeQuery(); ) {
					int count = 0;
					stmt.setString(1, keyPredicates.get(0).getText());
					if (rownumfilter != null) {
						while (count < rownumfilter-1 && rs.next()) { // move forward to the row right before the requested one 
							count++;
						}
						id = String.valueOf(rownumfilter);
					}
					if (rs.next()) {
						row = new Entity();
						row.setId(ODataUtils.createId(edmEntitySet.getName(), id));
						for (int i=0; i < rs.getMetaData().getColumnCount(); i++) {
							String columnname = rs.getMetaData().getColumnName(i+1);
							Object value = rs.getObject(i+1);
							row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
						}
					}
				}
			} catch (SQLException e) {
				throw new AppContainerSQLException(e, sql.toString(), "Execution of the query failed");
			}
	
			if (row == null) { // Bad request
				throw new ODataApplicationException("Entity not found",
						HttpStatusCode.NOT_FOUND.getStatusCode(), Locale.ENGLISH);
			}
	
			// 2.2. retrieve the property data from the entity
			Property property = row.getProperty(edmPropertyName);
			if (property == null) {
				throw new ODataApplicationException("Property not found",
						HttpStatusCode.NOT_FOUND.getStatusCode(), Locale.ENGLISH);
			}
	
			// 3. serialize
			Object value = property.getValue();
			if (value != null) {
				// 3.1. configure the serializer
				ODataSerializer serializer = odata.createSerializer(responseFormat);
	
				ContextURL contextUrl = ContextURL.with().entitySet(edmEntitySet).navOrPropertyPath(edmPropertyName).build();
				PrimitiveSerializerOptions options = PrimitiveSerializerOptions.with().contextURL(contextUrl).build();
				// 3.2. serialize
				SerializerResult serializerResult = serializer.primitive(serviceMetadata, edmPropertyType, property, options);
				InputStream propertyStream = serializerResult.getContent();
	
				//4. configure the response object
				response.setContent(propertyStream);
				response.setStatusCode(HttpStatusCode.OK.getStatusCode());
				response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());
			} else {
				// in case there's no value for the property, we can skip the serialization
				response.setStatusCode(HttpStatusCode.NO_CONTENT.getStatusCode());
			}
		} catch (AppContainerSQLException e) {
			throw new ODataApplicationException(e.getMessage(), 500, Locale.ENGLISH);
		}
	}
	
	@Override
	public void updatePrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo,
			ContentType requestFormat, ContentType responseFormat)
			throws ODataApplicationException, ODataLibraryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo)
			throws ODataApplicationException, ODataLibraryException {
		// TODO Auto-generated method stub
		
	}

}
