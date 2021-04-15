package io.rtdi.appcontainer.rest.odata.hanatable;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.Edm;
import org.apache.olingo.commons.api.edm.EdmAnnotation;
import org.apache.olingo.commons.api.edm.EdmElement;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmTerm;
import org.apache.olingo.commons.api.edm.annotation.EdmConstantExpression;
import org.apache.olingo.commons.api.edm.geo.Geospatial.Dimension;
import org.apache.olingo.commons.api.edm.geo.LineString;
import org.apache.olingo.commons.api.edm.geo.MultiLineString;
import org.apache.olingo.commons.api.edm.geo.Point;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.commons.core.edm.EdmPropertyImpl;
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
import org.geojson.GeoJsonObject;
import org.geojson.LngLatAlt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.sap.db.jdbc.HanaClob;

import io.rtdi.appcontainer.rest.odata.ODataFilterExpressionVisitor;
import io.rtdi.appcontainer.rest.odata.ODataSQLProjectionBuilder;
import io.rtdi.appcontainer.rest.odata.ODataUtils;
import io.rtdi.appcontainer.utils.HanaDataType;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class ODataCollectionProcessor implements EntityCollectionProcessor {
	private static int invocations = 0;
	private static long starttime = System.currentTimeMillis();
	private static long lastprocessedtime = 0;
	private Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	private static Cache<String, ResultCache> resultcache = Caffeine.newBuilder()
		    .expireAfterWrite(5, TimeUnit.MINUTES)
		    .maximumSize(1000)
		    .removalListener((String key, ResultCache resultcache, RemovalCause cause) ->
	        	{ 
	        		try {
	        			if (cause != RemovalCause.EXPLICIT) {
	        				resultcache.stmt.close();
	        			}
					} catch (SQLException e) {
					}
	        	} )
		    .build();


	private OData odata;
	private ServiceMetadata serviceMetadata;
	private Connection conn;
	private String schemaname;
	private String viewname;
	private Edm edm;
	private EdmTerm columnnameterm;

	public ODataCollectionProcessor(Connection conn, String schemaname, String viewname, ServiceMetadata edm) {
		this.conn = conn;
		this.schemaname = schemaname;
		this.viewname = viewname;
		this.edm = edm.getEdm();
		this.columnnameterm = edm.getEdm().getTerm(ODataEdm.columnnamefqn);
	}

	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;
	}

	@Override
	public void readEntityCollection(ODataRequest request, ODataResponse response, UriInfo uriInfo,
			ContentType responseFormat) throws ODataApplicationException, ODataLibraryException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<String, String> columnnameindex = null;
		String selectList = null;
		try {
			// 1st we have retrieve the requested EntitySet from the uriInfo object (representation of the parsed service URI)
			List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
			UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0); // in our example, the first segment is the EntitySet
			EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();
			EdmEntityType edmEntityType = edmEntitySet.getEntityType();
			
			SelectOption selectOption = uriInfo.getSelectOption();
			EdmEntityType entitytype = edm.getEntityContainer().getEntitySet(ODataEdm.ENTITY_SET_NAME).getEntityType();
			if (uriInfo.getSkipTokenOption() != null && uriInfo.getSkipTokenOption().getValue() != null) {
				String skiptoken = uriInfo.getSkipTokenOption().getValue();
				ResultCache r = resultcache.getIfPresent(skiptoken);
				if (r == null) {
					throw new ODataApplicationException("Cannot find the $skiptoken value in the cache, probably the followup query was more than 5 minutes after?", 404, null);
				} else {
					rs = r.rs;
					stmt = r.stmt;
					columnnameindex = r.columnnameindex;
					selectList = r.selectList;
					resultcache.invalidate(skiptoken);
				}
			} else {
				ODataSQLProjectionBuilder selectparser = new ODataSQLProjectionBuilder(edm);
				String sqlprojection = selectparser.buildSelectList(edmEntityType, null, selectOption);
				selectList = odata.createUriHelper().buildContextURLSelectList(edmEntityType, null, selectOption);
	
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
				    	topNumber = 5000;
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
						
				/*
				 * The columnname does not need to match the propertyname, e.g. because the column name is "/BIC/COL1" and
				 * that is not an allowed xml token name. Therefore the EDM does add a columnname annotation to every property.
				 * In many cases they are identical but not always.
				 */
				columnnameindex = new HashMap<>();
				for (String propertyname : entitytype.getPropertyNames()) {
					EdmElement element = entitytype.getProperty(propertyname);
					if (element != null && element instanceof EdmPropertyImpl) {
						EdmPropertyImpl prop = (EdmPropertyImpl) element;
						EdmAnnotation annotation = prop.getAnnotation(columnnameterm, null);
						if (annotation != null) {
							EdmConstantExpression columnname = annotation.getExpression().asConstant();
							if (columnname != null && !columnname.getValueAsString().equals(propertyname)) {
								/*
								 * Only entries with differences are put into the map to speed up processing.
								 * In best case, this is an empty map now.
								 */
								columnnameindex.put(columnname.getValueAsString(), propertyname);
							}
						}
					}
				}
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
			}
			// 2nd: fetch the data from backend for this requested EntitySetName
			// it has to be delivered as EntitySet object
			EntityCollection entitycollection = new EntityCollection();
			List<Entity> entitylist = entitycollection.getEntities();
			int rowsremaining = 5000;
			while (rowsremaining > 0 && rs.next()) {
				Entity row = new Entity();
				for (int i=0; i < rs.getMetaData().getColumnCount(); i++) {
					String columnname = rs.getMetaData().getColumnName(i+1);
					String propertyname = columnnameindex.get(columnname);
					if (propertyname == null) {
						/*
						 * As said above, the map has entries for different names only. 
						 */
						propertyname = columnname;
					}
					EdmElement element = entitytype.getProperty(propertyname);
					HanaDataType datatype = ODataUtils.getHanaDataType(element.getType());
					Object value;
					if (datatype != null) {
						switch (datatype) {
						case ALPHANUM:
						case BINARY:
						case BINTEXT:
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
							if (value instanceof HanaClob) {
								HanaClob clob = (HanaClob) value;
								Reader r = clob.getCharacterStream();
								char[] arr = new char[8 * 1024];
							    StringBuilder buffer = new StringBuilder();
							    int len;
							    while ((len = r.read(arr, 0, arr.length)) != -1) {
							        buffer.append(arr, 0, len);
							    }
							    r.close();
							    value = buffer.toString();
							}
							if (datatype == HanaDataType.ST_GEOMETRY || datatype == HanaDataType.ST_POINT) {
								ObjectMapper mapper = new ObjectMapper();
								GeoJsonObject geo = mapper.readValue(value.toString(), GeoJsonObject.class);
								MultiLineString m;
								if (geo instanceof org.geojson.MultiLineString) {
									org.geojson.MultiLineString geom = (org.geojson.MultiLineString) geo;
									List<LineString> olines = new ArrayList<>();
									List<List<LngLatAlt>> coords = geom.getCoordinates();
									for (List<LngLatAlt> geoline : coords) {
										List<Point> opoints = new ArrayList<>();
										for (LngLatAlt point : geoline) {
											Point op = new Point(Dimension.GEOGRAPHY, null);
											op.setX(point.getLongitude());
											op.setY(point.getLatitude());
											op.setZ(point.getAltitude());
											opoints.add(op);
										}
										LineString olinestring = new LineString(Dimension.GEOGRAPHY, null, opoints);
										olines.add(olinestring);
									}
									m = new MultiLineString(Dimension.GEOGRAPHY, null, olines);
									row.addProperty(new Property(null, propertyname, ValueType.GEOSPATIAL, m));
								}
							} else {
								row.addProperty(new Property(null, propertyname, ValueType.PRIMITIVE, value));
							}
							break;
						case BLOB:
							// TODO: BLOB not implemented yet
							break;
						case DATE: // 2010-01-01
							value = rs.getDate(i+1);
							row.addProperty(new Property(null, propertyname, ValueType.PRIMITIVE, value));
							break;
						case TIME: // 10:00:00
							value = rs.getTime(i+1);
							row.addProperty(new Property(null, propertyname, ValueType.PRIMITIVE, value));
							break;
						case SECONDDATE: // 2009-12-31T23:00:00Z
						case TIMESTAMP:
							value = rs.getTimestamp(i+1, cal); // would love to get the Instant directly but the driver does not allow for that
							row.addProperty(new Property(null, propertyname, ValueType.PRIMITIVE, value));
							break;
						}
						/* if (columnname.equalsIgnoreCase("id")) {
							row.setId(ODataUtils.createId(edmEntitySet.getName(), value));
						} */
					} else {
						throw new HanaSQLException("No data type found for oData element \"" + columnname + 
								"\" with type \"" + element.getType().getName() + "\"", null);
					}
				}
				rowsremaining--;
				entitylist.add(row);
			}
			
			if (rowsremaining == 0 && !rs.isAfterLast()) {
				/*
				 * When not all data was fetched preserve the current state of the SQL in a cache.
				 * In case the data is requested using the generated skip token, continue reading, else
				 * the statement should be closed when the cache entry is emptied after 5 minute window of 
				 * opportunity to continue reading.
				 */
				String skiptoken = String.valueOf(new Random().nextInt());
				String originaluri = request.getRawRequestUri();
				
				/*
				 * Take the original URI string and replace the old $skiptoken with the new one.
				 */
				Matcher matcher = Pattern.compile("\\$skiptoken=[+-]?\\d+").matcher(originaluri);
				StringBuffer b = new StringBuffer();
				URI nexturi;
				if (matcher.find()) {
					matcher.appendReplacement(b, "$skiptoken="+skiptoken);
					matcher.appendTail(b);
					nexturi = new URI(b.toString());
				} else {
					/*
					 * When no $skiptoken was found, add a new one. Depending on if the current url has query parameters already or not
					 * either an additional parameter is added with & or a first parameter with ?.
					 */
					if (originaluri.contains("?")) {
						nexturi = new URI(originaluri + "&$skiptoken=" + skiptoken);
					} else {
						nexturi = new URI(originaluri + "?$skiptoken=" + skiptoken);
					}
				}
				entitycollection.setNext(nexturi);
				resultcache.put(skiptoken, new ResultCache(stmt, rs, columnnameindex, selectList));
			} else {
				stmt.close();
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
		} catch (SQLException e) {
			throw new ODataApplicationException("SQL Error: " + e.getMessage(), 500, Locale.ENGLISH, e);
		} catch (HanaSQLException e) {
			throw new ODataApplicationException("SQL Error: " + e.getMessage(), 500, Locale.ENGLISH, e);
		} catch (Exception e) {
			throw new ODataApplicationException("Exception: " + e.getMessage(), 500, Locale.ENGLISH, e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
				}
			}
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

    public static class ResultCache {
		PreparedStatement stmt;
    	ResultSet rs;
    	Map<String, String> columnnameindex;
    	String selectList;
    	
    	public ResultCache(PreparedStatement stmt, ResultSet rs, Map<String, String> columnnameindex, String selectList) {
			this.stmt = stmt;
			this.rs = rs;
			this.columnnameindex = columnnameindex;
			this.selectList = selectList;
		}
    }
}
