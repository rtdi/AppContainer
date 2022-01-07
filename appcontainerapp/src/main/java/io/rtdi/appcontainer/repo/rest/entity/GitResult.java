package io.rtdi.appcontainer.repo.rest.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.RebaseResult;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate;

public class GitResult {

	private int successful = 0;
	private int failed = 0;
	private int uptodate = 0;
	private boolean commit = false;
	private List<String> operationlist = null;
	private List<String> messagelist = null;

	public String getSummary() {
		return String.format("successful: %d, failed: %d, uptodate: %d", successful, failed, uptodate);
	}

	public void setCommitCalled(boolean called) {
		commit = called;
	}

	public boolean getCommitCalled() {
		return commit;
	}

	public void addMessage(String message) {
		if (messagelist == null) {
			messagelist = new ArrayList<>();
		}
		messagelist.add(message);
	}

	public void addOperation(String message) {
		if (operationlist == null) {
			operationlist = new ArrayList<>();
		}
		operationlist.add(message);
	}

	public void add(PushResult pushResult) {
		if (pushResult != null && pushResult.getRemoteUpdates() != null) {
			Collection<RemoteRefUpdate> updates = pushResult.getRemoteUpdates();
			if (updates != null) {
				Iterator<RemoteRefUpdate> iterupdates = updates.iterator();
				while (iterupdates.hasNext()) {
					RemoteRefUpdate update = iterupdates.next();
					addMessage(update.getMessage());
					addOperation("push of " + update.getSrcRef() + " has status " + update.getStatus().name());
					switch (update.getStatus()) {
					case AWAITING_REPORT:
						break;
					case NON_EXISTING:
						break;
					case NOT_ATTEMPTED:
						break;
					case OK:
						successful++;
						break;
					case REJECTED_NODELETE:
					case REJECTED_NONFASTFORWARD:
					case REJECTED_OTHER_REASON:
					case REJECTED_REMOTE_CHANGED:
						failed++;
						break;
					case UP_TO_DATE:
						uptodate++;
						break;
					default:
						break;
					}
				}
			}
		}
	}

	public void add(FetchResult fetchResult) {
		if (fetchResult != null) { 
			if (fetchResult.getMessages() != null && fetchResult.getMessages().length() != 0) {
				addMessage(fetchResult.getMessages());
			}
			if (fetchResult.getAdvertisedRefs() != null) {
				Iterator<Ref> iter = fetchResult.getAdvertisedRefs().iterator();
				while (iter.hasNext()) {
					Ref ref = iter.next();
					addOperation("fetch ref " + ref.getName());
				}
			}
		}
	}

	public void add(MergeResult mergeResult) {
		if (mergeResult != null) { 
			if (mergeResult.getCheckoutConflicts() != null) {
				Iterator<String> iter = mergeResult.getCheckoutConflicts().iterator();
				while (iter.hasNext()) {
					String pathname = iter.next();
					addMessage("Checkout conflict: " + pathname);
				}
			}
			addMessage("Merge status: " + mergeResult.getMergeStatus().name());
		}
	}

	public void add(RebaseResult rebaseResult) {
		if (rebaseResult != null) { 
			if (rebaseResult.getConflicts() != null) {
				for (String pathname : rebaseResult.getConflicts()) {
					addOperation("Rebase conflict: " + pathname);
				}
			}
			addMessage("Rebase status: " + rebaseResult.getStatus().name());
		}
	}

	public List<String> getOperations() {
		return operationlist;
	}

	public List<String> getMessagelist() {
		return messagelist;
	}
}
