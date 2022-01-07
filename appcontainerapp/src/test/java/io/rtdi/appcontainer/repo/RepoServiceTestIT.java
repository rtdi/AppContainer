package io.rtdi.appcontainer.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import io.rtdi.appcontainer.util.RepoRestCalls;

class RepoServiceTestIT {
	private static RepoRestCalls c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new RepoRestCalls();
		
    	if (c.exists("/testreposervice")) {
    		c.rmdir("/testreposervice");
    	}
    	c.mkdir("/testreposervice");
    	c.mkdir("/testreposervice/dir1");
    	c.mkdir("/testreposervice/dir1/dirA");
    	c.mkdir("/testreposervice/dir2");
    	c.mkdir("/testreposervice/move1");
    	c.mkdir("/testreposervice/move1/move1a");
    	c.mkdir("/testreposervice/move2");
    	c.mkdir("/testreposervice/fileio");
    	c.touch("/testreposervice/rootfile.txt");
    	c.touch("/testreposervice/dir1/dirA/file1.txt");
    	c.touch("/testreposervice/dir1/dirA/file2.txt");
    	c.touch("/testreposervice/dir1/file.txt");
    	c.touch("/testreposervice/dir2/file.txt");
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		c.rmdir("/testreposervice");
		c.close();
	}

	@Test
	void testDir() {
		try {
			JsonNode n1 = c.dir(""); // {"folders":[{"folders":[{"folders":[{"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}],"name":"dir1","path":"testreposervice/dir1","filecount":1},{"folders":null,"name":"dir2","path":"testreposervice/dir2","filecount":1},{"folders":null,"name":"move2","path":"testreposervice/move2","filecount":1},{"folders":[{"folders":null,"name":"move1a","path":"testreposervice/move4/move1a","filecount":0}],"name":"move4","path":"testreposervice/move4","filecount":1}],"name":"testreposervice","path":"testreposervice","filecount":1}],"name":null,"path":null,"filecount":0}
			Map<String, JsonNode> s = c.getJsonKV(n1);
			assertTrue(s.containsKey("folders->path:testreposervice"), "Missing directory testreposervice");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir1"), "Missing directory testreposervice/dir1");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir2"), "Missing directory testreposervice/dir2");
			assertTrue(s.containsKey("folders->folders->folders->path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			assertTrue(s.containsKey("folders->folders->folders->filecount:2"), "directory testreposervice/dir1/dirA does not contain two files");
			JsonNode n2 = c.dir("/testreposervice"); // {"folders":[{"folders":[{"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}],"name":"dir1","path":"testreposervice/dir1","filecount":1},{"folders":null,"name":"dir2","path":"testreposervice/dir2","filecount":1},{"folders":null,"name":"move2","path":"testreposervice/move2","filecount":1},{"folders":[{"folders":null,"name":"move1a","path":"testreposervice/move4/move1a","filecount":0}],"name":"move4","path":"testreposervice/move4","filecount":1}],"name":"testreposervice","path":"testreposervice","filecount":1}
			s = c.getJsonKV(n2);
			assertTrue(s.containsKey("path:testreposervice"), "Missing directory testreposervice");
			assertTrue(s.containsKey("folders->path:testreposervice/dir1"), "Missing directory testreposervice/dir1");
			assertTrue(s.containsKey("folders->path:testreposervice/dir2"), "Missing directory testreposervice/dir2");
			assertTrue(s.containsKey("folders->folders->path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			JsonNode n3 = c.dir("/testreposervice/dir1/dirA"); // {"folders":null,"name":"dirA","path":"testreposervice/dir1/dirA","filecount":2}
			s = c.getJsonKV(n3);
			assertTrue(s.containsKey("path:testreposervice/dir1/dirA"), "Missing directory testreposervice/dir1/dirA");
			assertThrows(IOException.class, () -> c.dir("/doesnotexist"), "A dir call on a non-existing directory should return with a !=200 status code");
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

	@Test
	void testListFiles() {
		try {
			JsonNode n1 = c.listFiles(""); // {"path":null,"files":[]}
			Map<String, JsonNode> s = c.getJsonKV(n1);
			assertTrue(s.containsKey("files:"), "Root directory does not have files");
			JsonNode n2 = c.listFiles("/testreposervice"); // {"path":"testreposervice","files":[{"name":"rootfile.txt","extension":"txt","path":"testreposervice/rootfile.txt"}]}
			s = c.getJsonKV(n2);
			assertTrue(s.containsKey("files->path:testreposervice/rootfile.txt"), "The testreposervice directory must have one file");
			JsonNode n3 = c.listFiles("/testreposervice/dir1/dirA"); // {"path":"testreposervice/dir1/dirA","files":[{"name":"file1.txt","extension":"txt","path":"testreposervice/dir1/dirA/file1.txt"},{"name":"file2.txt","extension":"txt","path":"testreposervice/dir1/dirA/file2.txt"}]}
			s = c.getJsonKV(n3);
			assertTrue(s.containsKey("files->path:testreposervice/dir1/dirA/file1.txt"), "The testreposervice/dir1/dirA/file1.txt must exist");
			assertTrue(s.containsKey("files->path:testreposervice/dir1/dirA/file2.txt"), "The testreposervice/dir1/dirA/file2.txt must exist");
			assertThrows(IOException.class, () -> c.listFiles("/doesnotexist"), "A list files call on a non-existing directory should return with a !=200 status code");
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

	@Test
	void testMoveFilesAndDirs() {
		try {
			c.touch("/testreposervice/move1/filetomove.txt");
			JsonNode n1 = c.mv("/testreposervice/move1/filetomove.txt", "/testreposervice/move1/move1a/filetomove.txt"); // {"message":"OK"}
			assertTrue(c.isSuccess(n1), "failed to mv testreposervice/move1/filetomove.txt testreposervice/move1/move1a/filetomove.txt");
			JsonNode n2 = c.mv("/testreposervice/move1/move1a/filetomove.txt", "/testreposervice/move2/filetomove.txt"); // {"message":"OK"}
			assertTrue(c.isSuccess(n2), "failed to mv testreposervice/move1/move1a/filetomove.txt testreposervice/move2/filetomove.txt");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move1/move1a/filetomove.txt", "/testreposervice/move2/filetomove.txt"),
					"A mv call on a non-existing file should return with a !=200 status code");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move2/filetomove.txt", "/testreposervice/move3/filetomove.txt"),
					"A mv call into a non-existing dir should return with a !=200 status code");
			assertThrows(IOException.class, () -> c.mv("/testreposervice/move2/filetomove.txt", "/testreposervice/dir1/file.txt"),
					"A mv call over an existing file should return with a !=200 status code");
			JsonNode n3 = c.mv("/testreposervice/move1", "/testreposervice/move3"); // {"message":"OK"}
			assertTrue(c.isSuccess(n3), "failed to mv testreposervice/move1 testreposervice/move3");
			c.touch("/testreposervice/move3/filetomove.txt");
			JsonNode n4 = c.mv("/testreposervice/move3", "/testreposervice/move4"); // {"message":"OK"}
			assertTrue(c.isSuccess(n4), "failed to mv testreposervice/move3 testreposervice/move4");
			assertTrue(c.exists("/testreposervice/move4/filetomove.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

	@Test
	void testSaveRead() {
		try {
			String data1 = "Hello world";
			String data2 = "Hello\nNew world\r\n";
			assertTrue(c.isSuccess(c.save("/testreposervice/fileio/hello.txt", data1)), "Failed to save the file");
			JsonNode n1 = c.read("/testreposervice/fileio/hello.txt");
			assertEquals(data1, n1.get("content").textValue(), "Read content not equal to content when file was created");
			assertTrue(c.isSuccess(c.save("/testreposervice/fileio/hello.txt", data2)), "Failed to save new contents to the file");
			JsonNode n2 = c.read("/testreposervice/fileio/hello.txt");
			assertEquals(data2, n2.get("content").textValue(), "Read content not equal latest content");
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

}
