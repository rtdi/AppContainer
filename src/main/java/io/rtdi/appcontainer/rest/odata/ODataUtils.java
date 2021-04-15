package io.rtdi.appcontainer.rest.odata;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.EdmType;
import org.apache.olingo.commons.api.edm.constants.EdmTypeKind;
import org.apache.olingo.commons.api.ex.ODataRuntimeException;

import io.rtdi.appcontainer.utils.HanaDataType;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class ODataUtils {
	private static final String ESC_START = "__x";
	private static final String ESC_END = "_";

	private final static Set<Integer> toEscape = Stream.of((int)' ', 0xA, 0xD, 0xA0, 0x2F,
	        0x2002, 0x2003, 0x2004, 0x2005, 0x2006, 0x2007, 0x2008, 0x2009, 0x200A,
	        0x205F, 0x3000).collect(Collectors.toSet());

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
			case Int16:
				return HanaDataType.SMALLINT;
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

	public static String escapeXmlTag(String name) {
		if (name == null) {
			return null;
		} else {
		    StringBuilder sb = new StringBuilder();
		    for(int i=0; i<name.length();i++){
		        char c = name.charAt(i);
		        if (toEscape.contains((int) c)){
		            sb.append(ESC_START);
		            sb.append(Integer.toHexString((int) c));
		            sb.append(ESC_END);
		        } else {
		            sb.append(c);
		        }
		    }
		    return sb.toString();
		}
	}

}

