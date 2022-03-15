# Git integration

Git has a lot of advanced features required for large software development projects. Branching, push request, commit review, different merge strategies, and more. 
While it is good to have those, for small projects it overwhelms the end user.

For a project with a handful developers and all working on different areas, the fast-forward strategy is enough. A git pull will identify modified remote files and can overwritten in the local repository. Changed local files can be overwritten in the remote repository by a git push.

A more advanced project setup will require to switch between different branches, e.g. the v2 branch is the newest version but in case a quick bug fix on the current version is needed, the developer does switch to a new branch v1, does modify the code and push it.
This is a setup where each major version has one branch.

Optionally a new branch is created based on any existing branch and a pull request added during push, to ask the maintainer to review the code and add it.

Only once multiple developers work on the same file, collisions can appear and must be resolved.
Git has various strategies for that. The most common on is to compare two versions and if the code changes have been in different, non-overlapping, areas git creates a version which contains the changes of both.

While this works fine for source code, it does not for deeply nested structures like XML files and for small files where the likelihood of two developers changing the same lines is high. Such collisions are resolved by git in way that visual aid is added in that area with before/after information. For a structured file that means it is corrupt now.

To avoid that the repository browser service is using the merge-OURS strategy explicitly. A git pull gets all the remote versions and if there are version collisions, the local version is put over the pulled version.

These methods should allow for smooth operation in small projects. Together with the fact that the entire development can be split into multiple git repositories and in worst case the files are available in the filesystem and can be modified using gitbash or any other tool, does allow for the exceptional case.

## Implementation

Responsible for all git operations is the [GitService](https://git.sbg.ac.at/s1080660/bachelor/-/blob/main/appcontainerapp/src/main/java/io/rtdi/appcontainer/repo/rest/GitService.java) Restful API. 
It is using the JGit library and its code for the git-push looks like this:

```
try (Git git = Git.open(gitpath.toFile());) {
    if (git != null) {
        String url = git.getRepository().getConfig().getString("remote", "origin", "url");
        if (url == null) {
            throw new IOException("No git remote url specified yet");
        } else {
            GitResult result = new GitResult();
            PullResult pullresult = git.pull()
                .setRemote("origin")
                .setContentMergeStrategy(ContentMergeStrategy.OURS)
                .setCredentialsProvider(getGitConfig(git, up).createUserPasswordProvider())
                .call();
            result.add(pullresult.getFetchResult());
            result.add(pullresult.getMergeResult());
            result.add(pullresult.getRebaseResult());
            return Response.ok(result).build();
        }
    } else {
        return ErrorMessage.createResponse("Git not configured");
    }
}
```

It does a Git.open() on the previously created git repository, validates that all settings are present, configures the git.pull() call with the remote name, merge strategy and credentials. All details of the operation is collected in a result object an returned to the caller as JSON.

All git operations are built to be as simple as possible. But as the JGit works on normal files, an administrator can use any git tool on the directory. He is not limited to this GitService APIs only.
