package io.rtdi.appcontainer.dbunittest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
import io.rtdi.appcontainer.plugins.database.ICatalogService;

public class JavaScriptExecutor implements IActivationService {

	private Path rootpath;

	public JavaScriptExecutor(Path rootpath) {
		this.rootpath = rootpath;
	}

	@Override
	public ActivationResult activate(File file, Connection conn, GlobalSchemaMapping gm, SQLVariables variables,
			ICatalogService catalogservice) throws IOException, SQLException {
		String code = Files.readString(file.toPath());
		ByteArrayOutputStream log = new ByteArrayOutputStream();
		ActivationResult result = new ActivationResult(file.toPath(), "Executing test");
		FileSystem fs = FileSystem.newDefaultFileSystem();
		
		try (Context context = Context.newBuilder("js").logHandler(log).fileSystem(fs).allowIO(true).build(); ) {
			Commands commands = new Commands(conn, rootpath);
			context.getBindings("js").putMember("db", commands);
            context.eval("js", code);
            String loginfo = new String(log.toByteArray());
            result.addResult(null, loginfo, loginfo, ActivationSuccess.SUCCESS);
            return result;
        } catch (PolyglotException | IllegalStateException e) {
        	result.addResult(file.toPath(), e.getMessage(), new String(log.toByteArray()), ActivationSuccess.FAILED);
        	return result;
        }
	}
}
