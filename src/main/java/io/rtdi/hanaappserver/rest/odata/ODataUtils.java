package io.rtdi.hanaappserver.rest.odata;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.EdmType;
import org.apache.olingo.commons.api.edm.constants.EdmTypeKind;
import org.apache.olingo.commons.api.ex.ODataRuntimeException;

import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class ODataUtils {
	
	public static URI createId(String entitySetName, Object id) {
	    try {
	        return new URI(entitySetName + "(" + String.valueOf(id) + ")");
	    } catch (URISyntaxException e) {
	        throw new ODataRuntimeException("Unable to create id for entity: " + entitySetName, e);
	    }
	}

	public static HanaDataType getHanaDataType(EdmType type) throws HanaSQLException {
		if (type.getKind() == EdmTypeKind.PRIMITIVE) {
			EdmPrimitiveTypeKind edmprimitive = EdmPrimitiveTypeKind.valueOf(type.getName());
			switch (edmprimitive) {
			case String:
				return HanaDataType.NVARCHAR;
			case Int64:
				return HanaDataType.BIGINT;
			case Boolean:
				return HanaDataType.BOOLEAN;
			case Binary:
				return HanaDataType.BLOB;
			case Date:
				return HanaDataType.DATE;
			case Decimal:
				return HanaDataType.DECIMAL;
			case Double:
				return HanaDataType.DOUBLE;
			case Int32:
				return HanaDataType.INTEGER;
			case Single:
				return HanaDataType.REAL;
			case Geometry:
				return HanaDataType.ST_GEOMETRY;
			case GeometryPoint:
				return HanaDataType.ST_POINT;
			case TimeOfDay:
				return HanaDataType.TIME;
			case DateTimeOffset:
				return HanaDataType.TIMESTAMP;
			case SByte:
				return HanaDataType.TINYINT;
			default:
				return null;
			}
		}
		return null;
	}

}
