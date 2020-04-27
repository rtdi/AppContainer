package io.rtdi.hanaappserver.rest.odata.catalog;

import java.util.ArrayList;
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
import org.apache.olingo.commons.api.ex.ODataException;

import io.rtdi.hanaappserver.rest.odata.ODataSQLProjectionBuilder;

public class ODataCatalogEndpointsEdm extends CsdlAbstractEdmProvider {
	private CsdlEntityType entitytype;
	private FullQualifiedName objectfqn;
	private FullQualifiedName containerfqn;
	private CsdlEntitySet entityset;
	private CsdlEntityContainer container;
	private List<CsdlSchema> schemas;
	private CsdlEntityContainerInfo containerinfo;
	public static String NAMESPACE = "OData.ODataEndpoints";
	public static final String ANNOTATION_SQLMAPPING = NAMESPACE + ".sqlmapping";

	public ODataCatalogEndpointsEdm() {
		objectfqn = new FullQualifiedName(NAMESPACE, "ROW");
		containerfqn = new FullQualifiedName(NAMESPACE, "CONTAINER");
		List<CsdlProperty> columns = new ArrayList<CsdlProperty>();
		List<CsdlPropertyRef> keys = new ArrayList<CsdlPropertyRef>();
		columns.add(new CsdlProperty()
				.setName("SCHEMA_NAME")
				.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName())
				.setMaxLength(256));
		columns.add(new CsdlProperty()
				.setName("OBJECT_NAME")
				.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName())
				.setMaxLength(256));
		
		CsdlAnnotation sqlannotation = ODataSQLProjectionBuilder.getSQLMappingAnnotation(
				"'/HanaAppContainer/protected/odata/' || SCHEMA_NAME || '/' || OBJECT_NAME || '/'");
		CsdlProperty endpointproperty = new CsdlProperty()
				.setName("ENDPOINT")
				.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName())
				.setMaxLength(2048)
				.setAnnotations(Collections.singletonList(sqlannotation));
		columns.add(endpointproperty);
		columns.add(new CsdlProperty()
				.setName("OBJECT_TYPE")
				.setType(EdmPrimitiveTypeKind.String.getFullQualifiedName())
				.setMaxLength(32));
		keys.add(new CsdlPropertyRef()
				.setName("SCHEMA_NAME"));
		keys.add(new CsdlPropertyRef()
				.setName("OBJECT_NAME"));
		entitytype = new CsdlEntityType();
		entitytype.setName(objectfqn.getName());
		entitytype.setProperties(columns);
		entitytype.setKey(keys);

		entityset = new CsdlEntitySet();
		entityset.setName("TABLE");
		entityset.setType(objectfqn);

		List<CsdlEntitySet> entitySets = new ArrayList<CsdlEntitySet>();
		entitySets.add(entityset);

		
		// create EntityContainer
		container = new CsdlEntityContainer();
		container.setName(containerfqn.getName());
		container.setEntitySets(entitySets);

		// create Schema
		CsdlSchema schema = new CsdlSchema();
		schema.setNamespace(NAMESPACE);

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
		if (entityContainer.equals(containerfqn) && entitySetName.equals("TABLE")) {
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
