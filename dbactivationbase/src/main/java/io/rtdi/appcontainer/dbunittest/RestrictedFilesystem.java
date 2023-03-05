package io.rtdi.appcontainer.dbunittest;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Map;
import java.util.Set;

import org.graalvm.polyglot.io.FileSystem;

class RestrictedFileSystem implements FileSystem {

    private final FileSystem delegate;
    private final Path allowedFolder;

    RestrictedFileSystem(Path path) throws IOException {
        this.delegate = FileSystem.newDefaultFileSystem();
        this.allowedFolder = path;
    }

    @Override
    public Path parsePath(String path) {
        return delegate.parsePath(path);
    }

    @Override
    public Path parsePath(URI uri) {
        return delegate.parsePath(uri);
    }

    @Override
    public SeekableByteChannel newByteChannel(Path path,
                    Set<? extends OpenOption> options,
                    FileAttribute<?>... attrs) throws IOException {
        verifyAccess(path);
        return delegate.newByteChannel(path, options, attrs);
    }

    private void verifyAccess(Path path) {
        Path realPath = null;
        for (Path c = path; c != null; c = c.getParent()) {
            try {
                realPath = delegate.toRealPath(c);
                break;
            } catch (IOException ioe) {
            }
        }
        if (realPath == null || !realPath.startsWith(allowedFolder)) {
            throw new SecurityException("Access to " + path + " is denied.");
        }
    }

	@Override
	public void checkAccess(Path path, Set<? extends AccessMode> modes, LinkOption... linkOptions) throws IOException {
		delegate.checkAccess(path, modes, linkOptions);
	}

	@Override
	public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
		delegate.createDirectory(dir, attrs);
	}

	@Override
	public void delete(Path path) throws IOException {
		delegate.delete(path);
	}

	@Override
	public DirectoryStream<Path> newDirectoryStream(Path dir, Filter<? super Path> filter) throws IOException {
		return delegate.newDirectoryStream(dir, filter);
	}

	@Override
	public Path toAbsolutePath(Path path) {
		return delegate.toAbsolutePath(path);
	}

	@Override
	public Path toRealPath(Path path, LinkOption... linkOptions) throws IOException {
		return delegate.toRealPath(path, linkOptions);
	}

	@Override
	public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
		return delegate.readAttributes(path, attributes, options);
	}
}
