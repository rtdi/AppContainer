package io.rtdi.hanaappserver.rest.odata.hanatable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.provider.CsdlAbstractEdmProvider;
import org.apache.olingo.commons.api.edm.provider.CsdlAnnotation;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainer;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainerInfo;
import org.apache.olingo.commons.api.edm.provider.CsdlEntitySet;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityType;
import org.apache.olingo.commons.api.edm.provider.CsdlProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlPropertyRef;
import org.apache.olingo.commons.api.edm.provider.CsdlSchema;
import org.apache.olingo.commons.api.edm.provider.CsdlTerm;
import org.apache.olingo.commons.api.edm.provider.annotation.CsdlConstantExpression;
import org.apache.olingo.commons.api.ex.ODataException;

import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ODataEdm extends CsdlAbstractEdmProvider {
	public static final String ENTITY_SET_NAME = "TABLE";
	private CsdlEntityType entitytype;
	private FullQualifiedName objectfqn = new FullQualifiedName(namespace, "ROW");
	private FullQualifiedName containerfqn = new FullQualifiedName(namespace, "CONTAINER");
	private CsdlEntitySet entityset;
	private CsdlEntityContainer container;
	private List<CsdlSchema> schemas;
	private CsdlEntityContainerInfo containerinfo;
	public static final String namespace = "HANAOBJECT";

	public ODataEdm(Connection conn, String schemaname, String objectname) throws HanaSQLException {
		String sql = "select column_name, data_type_name, length, scale, comments, is_primary_key from (" +
				"select column_name, data_type_name, length, scale, comments, position, null as is_primary_key from view_columns \r\n" + 
				"where schema_name = ? and view_name = ? \r\n" + 
				"union all \r\n" +
				"select t.column_name, t.data_type_name, t.length, t.scale, t.comments, t.position, p.is_primary_key " +
				"from table_columns t\r\n" + 
				"left join constraints p on " +
				"  (p.schema_name = t.schema_name and p.table_name = t.table_name and p.column_name = t.column_name and p.is_primary_key = 'TRUE')" +
				"where t.schema_name = ? and t.table_name = ? \r\n" + 
				") order by position";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaname);
			stmt.setString(2, objectname);
			stmt.setString(3, schemaname);
			stmt.setString(4, objectname);
			try (ResultSet rs = stmt.executeQuery(); ) {
				List<CsdlProperty> columns = new ArrayList<CsdlProperty>();
				List<CsdlPropertyRef> keys = new ArrayList<CsdlPropertyRef>();
				while (rs.next()) {
					CsdlProperty c = new CsdlProperty()
							.setName(rs.getString(1));
					setODataType(c, rs.getString(2), rs.getInt(3), rs.getInt(4));
					columns.add(c);
					if (rs.getString(6) != null) {
						CsdlPropertyRef key = new CsdlPropertyRef();
						key.setName(rs.getString(1));
						keys.add(key);
					}
				}
				entitytype = new CsdlEntityType();
				entitytype.setName(objectfqn.getName());
				entitytype.setProperties(columns);
				if (keys.size() != 0) {
					entitytype.setKey(keys);
				}
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Tried to read the view definition");
		}
		entityset = new CsdlEntitySet();
		entityset.setName(ENTITY_SET_NAME);
		entityset.setType(objectfqn);
		CsdlAnnotation annotation1 = new CsdlAnnotation()
	            .setTerm("hana.schemaname")
	            .setExpression(new CsdlConstantExpression(CsdlConstantExpression.ConstantExpressionType.String, schemaname));
		CsdlAnnotation annotation2 = new CsdlAnnotation()
	            .setTerm("hana.objectname")
	            .setExpression(new CsdlConstantExpression(CsdlConstantExpression.ConstantExpressionType.String, objectname));
		entityset.setAnnotations(Arrays.asList(annotation1, annotation2));

		List<CsdlEntitySet> entitySets = new ArrayList<CsdlEntitySet>();
		entitySets.add(entityset);

		
		// create EntityContainer
		container = new CsdlEntityContainer();
		container.setName(containerfqn.getName());
		container.setEntitySets(entitySets);

		// create Schema
		CsdlSchema schema = new CsdlSchema();
		schema.setNamespace(namespace);

		// add EntityTypes
		List<CsdlEntityType> typelist = new ArrayList<CsdlEntityType>();
		typelist.add(entitytype);
		schema.setEntityTypes(typelist);

		// add EntityContainer
		schema.setEntityContainer(container);

		// finally
		schemas = new ArrayList<CsdlSchema>();
		schemas.add(schema);

		containerinfo = new CsdlEntityContainerInfo();
		containerinfo.setContainerName(containerfqn);

	}

	private void setODataType(CsdlProperty c, String datatype, int length, int scale) throws HanaSQLException {
		HanaDataType type = HanaDataType.valueOf(datatype);
		switch (type) {
		case ALPHANUM:
		case CHAR:
		case NCHAR:
		case NVARCHAR:
		case SHORTTEXT:
		case VARCHAR:
			c.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
			c.setMaxLength(length);
			break;
		case CLOB:
		case NCLOB:
		case BINTEXT:
		case TEXT:
			c.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
			break;
		case BIGINT:
			c.setType(EdmPrimitiveTypeKind.Int64.getFullQualifiedName());
			break;
		case BINARY:
		case VARBINARY:
			c.setType(EdmPrimitiveTypeKind.Binary.getFullQualifiedName());
			c.setMaxLength(length);
			break;
		case BLOB:
			c.setType(EdmPrimitiveTypeKind.Binary.getFullQualifiedName());
			break;
		case BOOLEAN:
			c.setType(EdmPrimitiveTypeKind.Boolean.getFullQualifiedName());
			break;
		case DATE:
			c.setType(EdmPrimitiveTypeKind.Date.getFullQualifiedName());
			break;
		case DECIMAL:
			if (length != 0) {
				c.setType(EdmPrimitiveTypeKind.Decimal.getFullQualifiedName());
				c.setPrecision(length);
				c.setScale(scale);
			} else {
				c.setType(EdmPrimitiveTypeKind.Double.getFullQualifiedName());
			}
			break;
		case DOUBLE:
			c.setType(EdmPrimitiveTypeKind.Double.getFullQualifiedName());
			break;
		case INTEGER:
			c.setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
			break;
		case REAL:
			c.setType(EdmPrimitiveTypeKind.Single.getFullQualifiedName());
			break;
		case SECONDDATE:
			c.setType(EdmPrimitiveTypeKind.DateTimeOffset.getFullQualifiedName());
			break;
		case SMALLDECIMAL:
			c.setType(EdmPrimitiveTypeKind.Double.getFullQualifiedName());
			break;
		case SMALLINT:
			c.setType(EdmPrimitiveTypeKind.Int16.getFullQualifiedName());
			break;
		case ST_GEOMETRY:
			c.setType(EdmPrimitiveTypeKind.Geometry.getFullQualifiedName());
			break;
		case ST_POINT:
			c.setType(EdmPrimitiveTypeKind.GeometryPoint.getFullQualifiedName());
			break;
		case TIME:
			c.setType(EdmPrimitiveTypeKind.TimeOfDay.getFullQualifiedName());
			break;
		case TIMESTAMP:
			c.setType(EdmPrimitiveTypeKind.DateTimeOffset.getFullQualifiedName());
			break;
		case TINYINT:
			c.setType(EdmPrimitiveTypeKind.SByte.getFullQualifiedName());
			break;
		default:
			throw new HanaSQLException("The Hana object has a column that is not handled by oData", datatype);
		}
	}

	@Override
	public CsdlEntityType getEntityType(FullQualifiedName entityTypeName) {
		if (entityTypeName.equals(objectfqn)) {
			return entitytype;
		} else {
			return null;
		}
	}

	@Override
	public CsdlEntitySet getEntitySet(FullQualifiedName entityContainer, String entitySetName) {
		if (entityContainer.equals(containerfqn) && entitySetName.equals(ENTITY_SET_NAME)) {
			return entityset;
		} else {
			return null;
		}
	}

	@Override
	public CsdlEntityContainer getEntityContainer() {
		return container;
	}

	@Override
	public List<CsdlSchema> getSchemas() {
		return schemas;
	}

	@Override
	public CsdlEntityContainerInfo getEntityContainerInfo(FullQualifiedName entityContainerName) {

		// This method is invoked when displaying the Service Document at e.g.
		// http://localhost:8080/DemoService/DemoService.svc
		if (entityContainerName == null || entityContainerName.equals(containerfqn)) {
			return containerinfo;
		} else {
			return null;
		}
	}
	
	@Override
	public CsdlTerm getTerm(final FullQualifiedName termName) throws ODataException {
		return new CsdlTerm().setType("Edm.String").setName(termName.getFullQualifiedNameAsString());
	}

}
