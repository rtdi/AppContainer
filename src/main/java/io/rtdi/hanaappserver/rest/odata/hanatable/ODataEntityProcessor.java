package io.rtdi.hanaappserver.rest.odata.hanatable;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
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
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataLibraryException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.EntityProcessor;
import org.apache.olingo.server.api.serializer.EntitySerializerOptions;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriParameter;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;

import io.rtdi.hanaappserver.rest.odata.ODataUtils;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ODataEntityProcessor implements EntityProcessor {
	private OData odata;
	private ServiceMetadata serviceMetadata;
	private Connection conn;
	private String schemaname;
	private String viewname;
	private Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

	public ODataEntityProcessor(Connection conn, String schemaname, String viewname, ServiceMetadata edm) {
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
	public void readEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType responseFormat)
			throws ODataApplicationException, ODataLibraryException {
		try {
			// 1. retrieve the Entity Type
		    List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
		    // Note: only in our example we can assume that the first segment is the EntitySet
		    UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0);
		    EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();

		    // 2. retrieve the data from backend
		    List<UriParameter> keyPredicates = uriResourceEntitySet.getKeyPredicates();
			Entity row = null;
			StringBuffer sql = new StringBuffer();
			sql.append("select ");
			sql.append('*');
			sql.append(" from \"")
				.append(schemaname)
				.append("\".\"")
				.append(viewname)
				.append("\" where ");
			boolean first = true;
			for ( UriParameter k : keyPredicates) {
				if (first) {
					first = false;
				} else {
					sql.append("AND ");
				}
				sql.append("\"" + k.getName() + "\" = ? "); 
			}
		    EdmEntityType entityType = edmEntitySet.getEntityType();
			try (PreparedStatement stmt = conn.prepareStatement(sql.toString());) {
				String id = "";
				for ( int i=0; i<keyPredicates.size(); i++) {
					UriParameter k = keyPredicates.get(i);
					EdmElement property = entityType.getProperty(k.getName());
					HanaDataType hanadatatype = ODataUtils.getHanaDataType(property.getType());
					String value = k.getText();
					switch (hanadatatype) {
					case ALPHANUM:
					case BINARY:
					case BINTEXT:
					case BLOB:
					case CHAR:
					case CLOB:
					case NCHAR:
					case NCLOB:
					case NVARCHAR:
					case SHORTTEXT:
					case ST_GEOMETRY:
					case ST_POINT:
					case TEXT:
					case VARBINARY:
					case VARCHAR:
						stmt.setString(i+1, value.substring(1, value.length()-1)); // trim leading ' chars
						break;
					case BIGINT:
					case DECIMAL:
					case DOUBLE:
					case INTEGER:
					case REAL:
					case SMALLDECIMAL:
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
					case SECONDDATE: // 2009-12-31T23:00:00Z
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
				}
				try (ResultSet rs = stmt.executeQuery(); ) {
					if (rs.next()) {
						row = new Entity();
						for (int i=0; i < rs.getMetaData().getColumnCount(); i++) {
							String columnname = rs.getMetaData().getColumnName(i+1);
							Object value = rs.getObject(i+1);
							row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
							// row.setId(ODataUtils.createId(edmEntitySet.getName(), id));
						}
					} else {
						throw new HanaSQLException("No data found for this query with the provided parameters", sql.toString());
					}
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql.toString(), "Execution of the query failed");
			}
	
		    // 3. serialize
	
		    ContextURL contextUrl = ContextURL.with().entitySet(edmEntitySet).build();
		    // expand and select currently not supported
		    EntitySerializerOptions options = EntitySerializerOptions.with().contextURL(contextUrl).build();
	
		    ODataSerializer serializer = odata.createSerializer(responseFormat);
		    SerializerResult serializerResult = serializer.entity(serviceMetadata, entityType, row, options);
		    InputStream entityStream = serializerResult.getContent();
	
		    //4. configure the response object
		    response.setContent(entityStream);
		    response.setStatusCode(HttpStatusCode.OK.getStatusCode());
		    response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());
		} catch (HanaSQLException e) {
			throw new ODataApplicationException(e.getMessage(), 500, Locale.ENGLISH);
		}
	}

	@Override
	public void createEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType requestFormat,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
	}

	@Override
	public void updateEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType requestFormat,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
	}

	@Override
	public void deleteEntity(ODataRequest request, ODataResponse response, UriInfo uriInfo)
			throws ODataApplicationException, ODataLibraryException {
	}

}
