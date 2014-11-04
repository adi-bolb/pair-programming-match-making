package org.findapair;

import org.findapair.pages.AvailableSessionsPage;
import org.findapair.pages.NoSessionsFoundPage;
import org.findapair.pages.Page;
import org.findapair.pages.PageLoader;

public class Pages {

    public String findAPair() {
		return getPageLoader().loadPage("find-a-pair.html");
	}

    public String pairHasBeenInvited() {
		return getPageLoader().loadPage("pair-invited.html");
	}

	public String invitationAccepted() {
		return getPageLoader().loadPage("invitation-accepted.html");
	}

	public String invitationRejected() {
		return getPageLoader().loadPage("invitation-rejected.html");
	}

    public Page getSessionsPage(AvailableSessions foundSessions) {
        if(foundSessions instanceof NoneSessions) return new NoSessionsFoundPage();
        return new AvailableSessionsPage(getPageLoader(), foundSessions);
    }

    private PageLoader getPageLoader() {
        return new PageLoader();
    }
}