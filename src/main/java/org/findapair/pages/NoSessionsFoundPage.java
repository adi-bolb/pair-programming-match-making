package org.findapair.pages;

import org.findapair.AvailableSessions;
import org.findapair.NoneSessions;

public class NoSessionsFoundPage implements Page{
    @Override
    public String render() {
        return new PageLoader().loadPage("no-session-found.html");
    }

    @Override
    public boolean canYouRender(AvailableSessions sessions){
        return sessions instanceof NoneSessions;
    }
}
