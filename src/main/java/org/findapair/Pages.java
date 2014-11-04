package org.findapair;

import org.findapair.pages.AvailableSessionsPage;
import org.findapair.pages.NoSessionsFoundPage;
import org.findapair.pages.Page;
import org.findapair.pages.PageLoader;

import java.util.Arrays;
import java.util.List;

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
        List<Page> pages = Arrays.asList(new NoSessionsFoundPage(), new AvailableSessionsPage(getPageLoader(), foundSessions));
        for (Page page : pages) {
            if(page.canYouRender(foundSessions)) return page;
        }
        throw new ThisShouldNeverHappenException(null);
    }

    private PageLoader getPageLoader() {
        return new PageLoader();
    }
}