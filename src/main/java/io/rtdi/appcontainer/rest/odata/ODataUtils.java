package io.rtdi.appcontainer.rest.odata;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.JDBCType;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.EdmType;
import org.apache.olingo.commons.api.edm.constants.EdmTypeKind;
import org.apache.olingo.commons.api.ex.ODataRuntimeException;

import io.rtdi.appcontainer.utils.AppContainerSQLException;

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

	public static JDBCType getJDBCDataType(EdmType type) throws AppContainerSQLException {
		if (type.getKind() == EdmTypeKind.PRIMITIVE) {
			EdmPrimitiveTypeKind edmprimitive = EdmPrimitiveTypeKind.valueOf(type.getName());
			switch (edmprimitive) {
			case String:
				return JDBCType.NVARCHAR;
			case Int64:
				return JDBCType.BIGINT;
			case Boolean:
				return JDBCType.BOOLEAN;
			case Binary:
				return JDBCType.BLOB;
			case Date:
				return JDBCType.DATE;
			case Decimal:
				return JDBCType.DECIMAL;
			case Double:
				return JDBCType.DOUBLE;
			case Int16:
				return JDBCType.SMALLINT;
			case Int32:
				return JDBCType.INTEGER;
			case Single:
				return JDBCType.REAL;
			case TimeOfDay:
				return JDBCType.TIME;
			case DateTimeOffset:
				return JDBCType.TIMESTAMP;
			case SByte:
				return JDBCType.TINYINT;
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

