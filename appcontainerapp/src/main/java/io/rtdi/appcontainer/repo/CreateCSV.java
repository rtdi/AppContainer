package io.rtdi.appcontainer.repo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class CreateCSV {
	
	public static int createCSV(Connection conn, String sql, Path targetpath, IDatabaseProvider provider) throws IOException, SQLException {
		JDBCDataTypeConversion conv = provider.getConversionClass();
		try (PreparedStatement stmt = conn.prepareStatement(sql); ) {
			try (ResultSet rs = stmt.executeQuery(); ) {
				// Writer header with column name and JDBCType
				ResultSetMetaData metadata = rs.getMetaData();
				try (Writer out = new BufferedWriter(new FileWriter(targetpath.toFile(), StandardCharsets.UTF_8));) {
					JDBCType[] columndatatypes = new JDBCType[metadata.getColumnCount()];
					for (int i = 0; i<metadata.getColumnCount(); i++) {
						if (i != 0) {
							out.write(',');
						}
						out.write(metadata.getColumnName(i+1));
						out.write(' ');
						columndatatypes[i] = JDBCType.valueOf(metadata.getColumnType(i+1));
						out.write(columndatatypes[i].name());
					}
					out.write("\r\n");
					int rowcount = 0;
					while (rs.next()) {
						for (int i = 0; i<metadata.getColumnCount(); i++) {
							if (i != 0) {
								out.write(',');
							}
							out.write(conv.convertJDBCToCSV(rs.getObject(i+1), columndatatypes[i]));
							rowcount++;
						}
						out.write("\r\n");
					}
					out.flush();
					return rowcount;
				}
			}
		}
	}

}
