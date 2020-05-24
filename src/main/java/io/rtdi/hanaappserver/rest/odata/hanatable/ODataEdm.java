package io.rtdi.hanaappserver.rest.odata.hanatable;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

import io.rtdi.hanaappserver.rest.odata.ODataUtils;
import io.rtdi.hanaappserver.utils.Describe;
import io.rtdi.hanaappserver.utils.Describe.ColumnDefinition;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ODataEdm extends CsdlAbstractEdmProvider {
	public static final String namespace = "HANAOBJECT";
	public static final String ENTITY_SET_NAME = "TABLE";
	public static final String HANA_COLUMNNAME_ANNOTATION = namespace + "." + ENTITY_SET_NAME + "." + "columnname";
	private CsdlEntityType entitytype;
	public static final FullQualifiedName objectfqn = new FullQualifiedName(namespace, "ROW");
	public static final FullQualifiedName containerfqn = new FullQualifiedName(namespace, "CONTAINER");
	public static final FullQualifiedName columnnamefqn = new FullQualifiedName(HANA_COLUMNNAME_ANNOTATION);
	private CsdlEntitySet entityset;
	private CsdlEntityContainer container;
	private List<CsdlSchema> schemas;
	private CsdlEntityContainerInfo containerinfo;

	public ODataEdm(Connection conn, String schemaname, String objectname) throws HanaSQLException {
		List<ColumnDefinition> columnlist = Describe.getObjectColumns(conn, schemaname, objectname);
		List<CsdlProperty> columns = new ArrayList<CsdlProperty>();
		List<CsdlPropertyRef> keys = new ArrayList<CsdlPropertyRef>();
		for (ColumnDefinition def : columnlist) {
			String columnname = def.getColumnname();
			/*
			 * Some column names cannot be expressed as xml tag names, hence need to be encoded.
			 * To find the way back, from column name to property name, these properties are annotated
			 * with the original column name.
			 */
			String propertyname = ODataUtils.escapeXmlTag(columnname);
			CsdlProperty c = new CsdlProperty()
					.setName(propertyname);
			if (!propertyname.equals(columnname)) {
				CsdlAnnotation annotationcolname = new CsdlAnnotation()
			            .setTerm(HANA_COLUMNNAME_ANNOTATION)
			            .setExpression(new CsdlConstantExpression(CsdlConstantExpression.ConstantExpressionType.String, columnname));
				c.setAnnotations(Collections.singletonList(annotationcolname));
			}
			setODataType(c, def.getDatatypename(), def.getLength(), def.getScale());
			columns.add(c);
			if (def.isKey()) {
				CsdlPropertyRef key = new CsdlPropertyRef();
				key.setName(columnname);
				keys.add(key);
			}			
		}
		entitytype = new CsdlEntityType();
		entitytype.setName(objectfqn.getName());
		entitytype.setProperties(columns);
		if (keys.size() != 0) {
			entitytype.setKey(keys);
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
