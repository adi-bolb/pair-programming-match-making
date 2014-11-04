package org.findapair.pages;

public class NoSessionsFoundPage implements Page{
    @Override
    public String render() {
        return new PageLoader().loadPage("no-session-found.html");
    }
}
