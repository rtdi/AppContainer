package io.rtdi.hanaappserver.rest.odata.hanatable;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.Edm;
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
import org.apache.olingo.server.api.processor.EntityCollectionProcessor;
import org.apache.olingo.server.api.serializer.EntityCollectionSerializerOptions;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.apache.olingo.server.api.uri.queryoption.CountOption;
import org.apache.olingo.server.api.uri.queryoption.FilterOption;
import org.apache.olingo.server.api.uri.queryoption.OrderByItem;
import org.apache.olingo.server.api.uri.queryoption.OrderByOption;
import org.apache.olingo.server.api.uri.queryoption.SelectOption;
import org.apache.olingo.server.api.uri.queryoption.SkipOption;
import org.apache.olingo.server.api.uri.queryoption.TopOption;
import org.apache.olingo.server.api.uri.queryoption.expression.Expression;
import org.apache.olingo.server.api.uri.queryoption.expression.ExpressionVisitException;
import org.apache.olingo.server.api.uri.queryoption.expression.Member;

import io.rtdi.hanaappserver.rest.odata.ODataFilterExpressionVisitor;
import io.rtdi.hanaappserver.rest.odata.ODataSQLProjectionBuilder;
import io.rtdi.hanaappserver.rest.odata.ODataUtils;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ODataCollectionProcessor implements EntityCollectionProcessor {
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;
	private Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

	private OData odata;
	private ServiceMetadata serviceMetadata;
	private Connection conn;
	private String schemaname;
	private String viewname;
	private Edm edm;

	public ODataCollectionProcessor(Connection conn, String schemaname, String viewname, ServiceMetadata edm) {
		this.conn = conn;
		this.schemaname = schemaname;
		this.viewname = viewname;
		this.edm = edm.getEdm();
	}

	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;
	}

	@Override
	public void readEntityCollection(ODataRequest request, ODataResponse response, UriInfo uriInfo,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
		try {
			// 1st we have retrieve the requested EntitySet from the uriInfo object (representation of the parsed service URI)
			List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
			UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0); // in our example, the first segment is the EntitySet
			EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();
			EdmEntityType edmEntityType = edmEntitySet.getEntityType();
			
			SelectOption selectOption = uriInfo.getSelectOption();
			ODataSQLProjectionBuilder selectparser = new ODataSQLProjectionBuilder(edm);
			String selectList = odata.createUriHelper().buildContextURLSelectList(edmEntityType, null, selectOption);
			String sqlprojection = selectparser.buildSelectList(edmEntityType, null, selectOption);

			StringBuffer sql = new StringBuffer();
			sql.append("select ");
			if (sqlprojection == null) {
				sql.append('*');
			} else {
				sql.append(sqlprojection);
			}
			sql.append(" from \"")
				.append(schemaname)
				.append("\".\"")
				.append(viewname)
				.append("\" ");
			
			FilterOption filterOption = uriInfo.getFilterOption();
			if(filterOption != null) {
				Expression filter = filterOption.getExpression();
				try {
					ODataFilterExpressionVisitor expressionVisitor = new ODataFilterExpressionVisitor();
					String visitorResult = filter.accept(expressionVisitor);
					sql.append("where ")
						.append(visitorResult)
						.append(' ');
				} catch (ExpressionVisitException e) {
					throw new ODataApplicationException("Exception in filter evaluation",
							HttpStatusCode.INTERNAL_SERVER_ERROR.getStatusCode(), Locale.ENGLISH);
				}
			}

			OrderByOption orderByOption = uriInfo.getOrderByOption();
			if (orderByOption != null) {
				List<OrderByItem> orderItemList = orderByOption.getOrders();
				if (orderItemList != null && orderItemList.size() > 0) {
					sql.append("order by ");
					boolean first = true;
					for (OrderByItem item : orderItemList) {
						if (first) {
							first = false;
						} else {
							sql.append(", ");
						}
						Member expr = (Member) item.getExpression(); 
						String columnname = expr.getResourcePath().getUriResourceParts().get(0).toString();
						sql.append('"')
							.append(columnname)
							.append('"');
						if (item.isDescending()) {
							sql.append(" desc ");
						}
					}
				}
			}
			
			TopOption topOption = uriInfo.getTopOption();
			if (topOption != null) {
			    int topNumber = topOption.getValue();
			    if (topNumber <= 0) {
			    	topNumber = 10000;
			    }
		    	sql.append("limit ")
		    		.append(topNumber)
		    		.append(' ');
			}

			SkipOption skipOption = uriInfo.getSkipOption();
			if (skipOption != null) {
			    int skipNumber = skipOption.getValue();
			    if (skipNumber > 0) {
			    	sql.append("offset ")
			    		.append(skipNumber)
			    		.append(' ');
			    }
			}
	
			// 2nd: fetch the data from backend for this requested EntitySetName
			// it has to be delivered as EntitySet object
			EntityCollection entitycollection = new EntityCollection();
			List<Entity> entitylist = entitycollection.getEntities();
			EdmEntityType entitytype = edm.getEntityContainer().getEntitySet(ODataEdm.ENTITY_SET_NAME).getEntityType();
			try (PreparedStatement stmt = conn.prepareStatement(sql.toString());) {
				try (ResultSet rs = stmt.executeQuery(); ) {
					while (rs.next()) {
						Entity row = new Entity();
						for (int i=0; i < rs.getMetaData().getColumnCount(); i++) {
							String columnname = rs.getMetaData().getColumnName(i+1);
							EdmElement element = entitytype.getProperty(columnname);
							HanaDataType datatype = ODataUtils.getHanaDataType(element.getType());
							Object value;
							switch (datatype) {
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
							case BIGINT:
							case DECIMAL:
							case DOUBLE:
							case INTEGER:
							case REAL:
							case SMALLDECIMAL:
							case SMALLINT:
							case TINYINT:
							case BOOLEAN:
							default:
								value = rs.getObject(i+1);
								row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
								break;
							case DATE: // 2010-01-01
								value = rs.getDate(i+1);
								row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
								break;
							case TIME: // 10:00:00
								value = rs.getTime(i+1);
								row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
								break;
							case SECONDDATE: // 2009-12-31T23:00:00Z
							case TIMESTAMP:
								value = rs.getTimestamp(i+1, cal); // would love to get the Instant directly but the driver does not allow for that
								row.addProperty(new Property(null, columnname, ValueType.PRIMITIVE, value));
								break;
							}
							if (columnname.equalsIgnoreCase("id")) {
								row.setId(ODataUtils.createId(edmEntitySet.getName(), value));
							}
						}
						entitylist.add(row);
					}
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql.toString(), "Execution of the query failed");
			}
			
			CountOption countOption = uriInfo.getCountOption();
			if (countOption != null) {
			    boolean isCount = countOption.getValue();
			    if(isCount){
			    	entitycollection.setCount(entitylist.size());
			    }
			}
			
	
			// 3rd: create a serializer based on the requested format (json)
			ODataSerializer serializer = odata.createSerializer(responseFormat);
	
			// 4th: Now serialize the content: transform from the EntitySet object to InputStream
			ContextURL contextUrl = ContextURL.with()
						.entitySet(edmEntitySet)
						.selectList(selectList)
						.build();
	
			final String id = request.getRawBaseUri() + "/" + edmEntitySet.getName();
			EntityCollectionSerializerOptions opts = EntityCollectionSerializerOptions.with().
					id(id)
					.contextURL(contextUrl)
					.count(countOption)
					.select(selectOption)
					.build();
			SerializerResult serializerResult = serializer.entityCollection(serviceMetadata, edmEntityType, entitycollection, opts);
			InputStream serializedContent = serializerResult.getContent();
	
			// Finally: configure the response object: set the body, headers and status code
			response.setContent(serializedContent);
			response.setStatusCode(HttpStatusCode.OK.getStatusCode());
			response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());
			invocations++;
			lastprocessedtime = System.currentTimeMillis();
		} catch (HanaSQLException e) {
			throw new ODataApplicationException("SQL Error: " + e.getMessage(), 500, Locale.ENGLISH, e);
		}
	}
	
    public static int getInvocations() {
    	return invocations;
    }

    public static long getStarttime() {
    	return starttime;
    }

    public static long getLastProcessedtime() {
    	return lastprocessedtime;
    }

}
