package io.rtdi.appcontainer.dbunittest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.io.FileSystem;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;
import io.rtdi.appcontainer.plugins.database.IActivationService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class JavaScriptExecutor implements IActivationService {

	private Path rootpath;

	public JavaScriptExecutor(Path rootpath) {
		this.rootpath = rootpath;
	}

	@Override
	public ActivationResult activate(File file, Connection conn, GlobalSchemaMapping gm, SQLVariables variables,
			IDatabaseProvider provider) throws IOException, SQLException {
		String code = Files.readString(file.toPath());
		try (ByteArrayOutputStream log = new ByteArrayOutputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ByteArrayOutputStream err = new ByteArrayOutputStream();) {
			ActivationResult result = new ActivationResult(file.toPath(), "Executing test");
			FileSystem fs = new RestrictedFileSystem(rootpath);
			
			try (Context context = Context.newBuilder("js").logHandler(log).out(out).err(err).fileSystem(fs).allowIO(true).build(); ) {
				Commands commands = new Commands(conn, rootpath, provider);
				context.getBindings("js").putMember("db", commands);
	            context.eval("js", code);
	            @SuppressWarnings("unused")
				String loginfo = new String(log.toByteArray());
	            String stderr = new String(err.toByteArray());
	            /*
	             * The script can write something to stderr or write the text "Assertion failed" to the stdout via console.assert().
	             * All these are considered a FAILED.
	             * Every other output line is returned as SUCCESS.
	             */
	            if (stderr.length() != 0 ) {
		            result.addResult(stderr, "JavaScript wrote something into stderr", ActivationSuccess.FAILED);
	            }
	            try (BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(out.toByteArray())));) {
		            for (String line; (line = br.readLine()) != null; ) {
			            // Example: Assertion failed: PROJECTS table does not have 30 records
			            result.addResult(line, null, (line.startsWith("Assertion failed")?ActivationSuccess.FAILED:ActivationSuccess.SUCCESS));
		            }
	            }
	            if (result.getChildren() == null || result.getChildren().size() == 0) {
	            	// If neiter sdtout nor stderr has an output add a dummy success message
		            result.addResult("No (error) messages produced", null, ActivationSuccess.SUCCESS);
	            }
	            return result;
	        } catch (PolyglotException | IllegalStateException e) {
	        	result.addResult(e.getMessage(), new String(log.toByteArray()), ActivationSuccess.FAILED);
	        	return result;
	        }
		}
	}
}
