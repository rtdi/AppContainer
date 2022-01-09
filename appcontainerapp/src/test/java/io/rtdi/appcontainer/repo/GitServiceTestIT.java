package io.rtdi.appcontainer.repo;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import io.rtdi.appcontainer.repo.rest.GitService.GitCommit;
import io.rtdi.appcontainer.repo.rest.GitService.GitConfig;
import io.rtdi.appcontainer.util.RepoRestCalls;

public class GitServiceTestIT {
	private final static String GITHUB_TOKEN = "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"; // "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";
	
	private static RepoRestCalls c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new RepoRestCalls();
		
    	if (c.exists("/testgitservice")) {
    		c.rmdir("/testgitservice");
    	}
    	c.mkdir("/testgitservice");
    	c.mkdir("/testgitservice/dir1");
    	c.mkdir("/testgitservice/dir1/gitprojectdirCase1");
    	c.mkdir("/testgitservice/dir1/gitprojectdirCase2");
    	c.mkdir("/testgitservice/dir1/gitprojectdirCase3");
    	c.mkdir("/testgitservice/dir1/gitprojectdirCase4");
    	c.mkdir("/testgitservice/dir1/gitprojectdirCase5");
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		c.rmdir("/testgitservice");
		c.close();
	}
	
	private GitConfig getGitConfig() {
		GitConfig gitcfg = new GitConfig();
		gitcfg.setUsername("wernerdaehn");
		gitcfg.setToken(GITHUB_TOKEN);
		gitcfg.setEmail("werner.daehn@rtdi.io");
		gitcfg.setRemoteurl("https://github.com/rtdi/temp.git");
		return gitcfg;
	}

	@Test
	void testCase() {
		/*
		 * Case #3: The local repo does not exist and the local folder is empty
		 * The repo will be cloned, then the file changed and this is pushed
		 */
		try {
			GitConfig gitcfg = getGitConfig();
			c.gitconfig("/testgitservice/dir1/gitprojectdirCase3", gitcfg);
			c.save("/testgitservice/dir1/gitprojectdirCase3/README.md", "# Sample Readme\r\n" + System.currentTimeMillis() + "\r\n");
			c.save("/testgitservice/dir1/gitprojectdirCase3/file1.txt", String.valueOf(System.currentTimeMillis()));
			GitCommit commit = new GitCommit();
			commit.setMessage("Commit Case3");
			JsonNode pushresult = c.gitpush("/testgitservice/dir1/gitprojectdirCase3", commit);
			System.out.println(pushresult);
			JsonNode pullresult = c.gitpull("/testgitservice/dir1/gitprojectdirCase3");
			System.out.println(pullresult);
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
		
		/*
		 * Case #4: The local filesystem has data but no git and the remote has data
		 * A git init will be called thus adding the existing file into git.
		 * Then the question is, if there is a file collision.
		 */
		try {
			c.save("/testgitservice/dir1/gitprojectdirCase4/README.md", "# Sample Readme\r\n" + System.currentTimeMillis() + "\r\n");
			GitConfig gitcfg = getGitConfig();
			c.gitconfig("/testgitservice/dir1/gitprojectdirCase4", gitcfg);
			c.save("/testgitservice/dir1/gitprojectdirCase4/file2.txt", String.valueOf(System.currentTimeMillis()));
			GitCommit commit = new GitCommit();
			commit.setMessage("Commit Case4-1");
			JsonNode pushresult = c.gitpush("/testgitservice/dir1/gitprojectdirCase4", commit);
			System.out.println(pushresult);
			JsonNode pullresult = c.gitpull("/testgitservice/dir1/gitprojectdirCase4");
			System.out.println(pullresult);
			commit.setMessage("Commit Case4-2");
			pushresult = c.gitpush("/testgitservice/dir1/gitprojectdirCase4", commit);
			System.out.println(pushresult);
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}

	}

}
