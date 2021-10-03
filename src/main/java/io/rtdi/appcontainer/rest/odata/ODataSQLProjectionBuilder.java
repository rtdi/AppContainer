package io.rtdi.appcontainer.rest.odata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.olingo.commons.api.edm.Edm;
import org.apache.olingo.commons.api.edm.EdmAnnotation;
import org.apache.olingo.commons.api.edm.EdmComplexType;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmNavigationProperty;
import org.apache.olingo.commons.api.edm.EdmProperty;
import org.apache.olingo.commons.api.edm.EdmStructuredType;
import org.apache.olingo.commons.api.edm.EdmTerm;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.annotation.EdmExpression;
import org.apache.olingo.commons.api.edm.provider.CsdlAnnotation;
import org.apache.olingo.commons.api.edm.provider.annotation.CsdlConstantExpression;
import org.apache.olingo.commons.core.Encoder;
import org.apache.olingo.server.api.serializer.SerializerException;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceComplexProperty;
import org.apache.olingo.server.api.uri.UriResourceNavigation;
import org.apache.olingo.server.api.uri.queryoption.ExpandOption;
import org.apache.olingo.server.api.uri.queryoption.SelectItem;
import org.apache.olingo.server.api.uri.queryoption.SelectOption;
import org.apache.olingo.server.core.serializer.utils.ExpandSelectHelper;

import io.rtdi.appcontainer.rest.odata.catalog.ODataCatalogEndpointsEdm;
import io.rtdi.appcontainer.rest.odata.table.ODataEdm;

public class ODataSQLProjectionBuilder {
	private EdmTerm sqlmappingterm;


	public ODataSQLProjectionBuilder(Edm edm) {
		super();
		this.sqlmappingterm = edm.getTerm(new FullQualifiedName(ODataCatalogEndpointsEdm.ANNOTATION_SQLMAPPING));
	}
	
	public static CsdlAnnotation getSQLMappingAnnotation(String sqlexpression) {
		return new CsdlAnnotation().setTerm(ODataCatalogEndpointsEdm.ANNOTATION_SQLMAPPING).setExpression(
				new CsdlConstantExpression(
						CsdlConstantExpression.ConstantExpressionType.String,
						sqlexpression)
				);
	}

	public String buildSelectList(final EdmStructuredType type, final ExpandOption expand,
			final SelectOption select) throws SerializerException {
		StringBuilder result = new StringBuilder();
		if (ExpandSelectHelper.hasSelect(select)) {
			handleSelect(type, select, result);
		}
		return result.length() == 0 ? null : result.toString();
	}

	private void handleSelect(EdmStructuredType type, final SelectOption select, final StringBuilder result) {
		if (ExpandSelectHelper.isAll(select)) {
			result.append('*');
		} else {
			final List<SelectItem> selectItems = select.getSelectItems();
			type = getTypeFromSelectItems(selectItems, type);
			final Set<String> selectedPropertyNames = ExpandSelectHelper.getSelectedPropertyNames(selectItems);
			for (final String propertyName : type.getPropertyNames()) {
				constructSelectItemList(type, result, selectItems, selectedPropertyNames, propertyName);
			}
			for (final String propertyName : type.getNavigationPropertyNames()) {
				constructSelectItemList(type, result, selectItems, selectedPropertyNames, propertyName);
			}
		}
	}


	/**
	 * This fetches the correct EntityType if there is an entity type cast specified
	 * in the select option of the url
	 * 
	 * @param selectItems
	 * @param type
	 * @return entity type
	 */
	private EdmStructuredType getTypeFromSelectItems(List<SelectItem> selectItems, EdmStructuredType type) {
		EdmStructuredType edmType = type;
		for (final SelectItem item : selectItems) {
			if (item.getStartTypeFilter() != null && item.getStartTypeFilter() instanceof EdmEntityType) {
				edmType = (EdmEntityType) item.getStartTypeFilter();
			}
		}
		return edmType;
	}

	/**
	 * @param type
	 * @param result
	 * @param selectItems
	 * @param selectedPropertyNames
	 * @param propertyName
	 */
	private void constructSelectItemList(final EdmStructuredType type, final StringBuilder result,
			final List<SelectItem> selectItems, final Set<String> selectedPropertyNames, final String propertyName) {
		if (!propertyName.equals(ODataEdm.ROWNUM)) {
			if (selectedPropertyNames.contains(propertyName)) {
				if (result.length() > 0) {
					result.append(',');
				}
				final EdmProperty edmProperty = type.getStructuralProperty(propertyName);
				final Set<List<String>> selectedPaths = ExpandSelectHelper.getSelectedPathsWithTypeCasts(selectItems,
						propertyName);
				if (selectedPaths == null) {
					String sqlexpression;
					if (edmProperty.getType().getName().equals("Geometry")) {
						sqlexpression = "\"" + propertyName + "\".ST_AsGeoJSON()";
					} else {
						sqlexpression = "\"" + propertyName + "\"";
					}
					EdmAnnotation annotation = edmProperty.getAnnotation(sqlmappingterm, null);
					if (annotation != null) {
						EdmExpression expr = annotation.getExpression();
						sqlexpression = expr.asConstant().getValueAsString(); 
					}
					result.append(sqlexpression + " as \"" + propertyName + "\"");
				} else {
					List<List<String>> complexSelectedPaths = edmProperty != null
							&& edmProperty.getType() instanceof EdmComplexType
									? getComplexSelectedPaths(edmProperty, selectedPaths)
									: new ArrayList<>();
					if (complexSelectedPaths.isEmpty()) {
						for (List<String> path : selectedPaths) {
							complexSelectedPaths.add(path);
						}
						int position = getPositionToAddProperty(selectItems, propertyName, selectedPaths);
						if (position == -1) {
							complexSelectedPaths.get(0).add(propertyName);
						} else {
							complexSelectedPaths.get(0).add(position, propertyName);
						}
					}
	
					boolean first = true;
					for (final List<String> path : complexSelectedPaths) {
						if (first) {
							first = false;
						} else {
							result.append(',');
						}
						boolean innerFirst = true;
						for (final String name : path) {
							if (innerFirst) {
								innerFirst = false;
							} else {
								result.append('/');
							}
							result.append(Encoder.encode(name));
						}
					}
				}
			} else {
				if (type instanceof EdmEntityType) {
					final List<String> keyNames = ((EdmEntityType) type).getKeyPredicateNames();
					if (keyNames.contains(propertyName)) {
						if (result.length() > 0) {
							result.append(',');
						}
						result.append(Encoder.encode(propertyName));
					}
				}
			}
		}
	}

	/**
	 * If there is a type filter on a complex property (complex type cast) or a type
	 * filter on a navigation property, this method finds the appropriate position
	 * to add the complex property or the navigation property in the result object
	 * 
	 * @param selectItems
	 * @param propertyName
	 * @param selectedPaths
	 * @return pos
	 */
	private int getPositionToAddProperty(List<SelectItem> selectItems, String propertyName,
			Set<List<String>> selectedPaths) {
		for (SelectItem item : selectItems) {
			final List<UriResource> parts = item.getResourcePath().getUriResourceParts();
			int i = 0;
			for (UriResource part : parts) {
				if (part instanceof UriResourceComplexProperty
						&& ((UriResourceComplexProperty) part).getProperty().getName().equalsIgnoreCase(propertyName)) {
					if (((UriResourceComplexProperty) part).getComplexTypeFilter() != null) {
						return getComplexPropertyPosition(selectedPaths, (UriResourceComplexProperty) part);
					} else {
						return i;
					}
				} else if (part instanceof UriResourceNavigation
						&& ((UriResourceNavigation) part).getProperty().getName().equalsIgnoreCase(propertyName)) {
					return -1;
				}
				i++;
			}
		}
		return -1;
	}

	/**
	 * @param selectedPaths
	 * @param part
	 */
	private int getComplexPropertyPosition(Set<List<String>> selectedPaths, UriResourceComplexProperty part) {
		for (List<String> pathSel : selectedPaths) {
			int i = 0;
			for (String sel : pathSel) {
				if (sel.equalsIgnoreCase(
						part.getComplexTypeFilter().getFullQualifiedName().getFullQualifiedNameAsString())) {
					return i;
				}
				i++;
			}
		}
		return 0;
	}

	private List<List<String>> getComplexSelectedPaths(final EdmProperty edmProperty,
			final Set<List<String>> selectedPaths) {
		List<List<String>> result = new ArrayList<>();
		if (selectedPaths == null) {
			List<String> path = new LinkedList<>();
			path.add(edmProperty.getName());
			result.add(path);
		} else {
			final EdmComplexType type = (EdmComplexType) edmProperty.getType();
			for (final String complexPropertyName : type.getPropertyNames()) {
				if (ExpandSelectHelper.isSelected(selectedPaths, complexPropertyName)) {
					List<List<String>> complexSelectedPaths = getComplexSelectedPaths(
							(EdmProperty) type.getProperty(complexPropertyName),
							ExpandSelectHelper.getReducedSelectedPaths(selectedPaths, complexPropertyName));
					for (final List<String> path : complexSelectedPaths) {
						path.add(0, edmProperty.getName());
						result.add(path);
					}
				}
			}
			for (final String complexPropertyName : type.getNavigationPropertyNames()) {
				if (ExpandSelectHelper.isSelected(selectedPaths, complexPropertyName)) {
					List<List<String>> complexSelectedPaths = getComplexSelectedPaths(
							(EdmNavigationProperty) type.getProperty(complexPropertyName));
					for (final List<String> path : complexSelectedPaths) {
						path.add(0, edmProperty.getName());
						result.add(path);
					}
				}
			}
		}
		return result;
	}

	private List<List<String>> getComplexSelectedPaths(EdmNavigationProperty edmProperty) {
		List<List<String>> result = new ArrayList<>();
		List<String> path = new LinkedList<>();
		path.add(edmProperty.getName());
		result.add(path);
		return result;
	}

}
