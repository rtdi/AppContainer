package io.rtdi.hanaappserver.rest.odata.catalog;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
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

import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.Util;

public class ODataCatalogEndpointsEntityProcessor implements EntityProcessor {
	private OData odata;
	private ServiceMetadata serviceMetadata;
	private Connection conn;

	public ODataCatalogEndpointsEntityProcessor(Connection conn) {
		this.conn = conn;
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
			String sql = "select schema_name, object_name, object_type from objects where schema_name = ? and object_name = ? and object_type in ('VIEW', TABLE')";
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setString(1, keyPredicates.get(0).getText());
				stmt.setString(2, keyPredicates.get(1).getText());
				try (ResultSet rs = stmt.executeQuery(); ) {
					if (rs.next()) {
						row = new Entity();
						String endpoint = "/HanaAppContainer/protected/odata/" + Util.encodeURIfull(rs.getString(1)) + "/" + Util.encodeURIfull(rs.getString(2)) + "/";
						row.addProperty(new Property(null, "SCHEMA_NAME", ValueType.PRIMITIVE, rs.getString(1)));
						row.addProperty(new Property(null, "OBJECT_NAME", ValueType.PRIMITIVE, rs.getString(2)));
						row.addProperty(new Property(null, "ENDPOINT", ValueType.PRIMITIVE, endpoint));
						row.addProperty(new Property(null, "OBJECT_TYPE", ValueType.PRIMITIVE, rs.getString(3)));
					}
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql, "Execution of the query failed");
			}
	
		    // 3. serialize
		    EdmEntityType entityType = edmEntitySet.getEntityType();
	
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
