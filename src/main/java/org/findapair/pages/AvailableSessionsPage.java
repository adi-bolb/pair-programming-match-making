package org.findapair.pages;

import org.findapair.AvailableSessions;
import org.findapair.Session;

public class AvailableSessionsPage implements Page {
    public static final String REPLACE_WITH_THIS = "<tr>\n" +
            "\t<td>%name%</td>\n" +
            "\t<td>%when%</td>\n" +
            "\t<td>\n" +
            "\t\t<form action=\"/invitations/%id%\" method=\"post\">\n" +
            "\t\t<input type=\"submit\" value=\"Let's pair\" />\n" +
            "\t\t</form>\n" +
            "\t</td>\n" +
            "</tr>\n";
    public static final String PAGE_NAME = "available-pairs.html";
    private PageLoader pageLoader;
    private AvailableSessions availableSessions;

    public AvailableSessionsPage(PageLoader pageLoader, AvailableSessions availableSessions) {
        this.pageLoader = pageLoader;
        this.availableSessions = availableSessions;
    }

    @Override
    public String renderAsAvailable() {
        StringBuilder buf = new StringBuilder();
        for (Session session : availableSessions) {
            buf.append(renderAsAvailable(session));
        }
        final String html = pageLoader.loadPage(PAGE_NAME);
        return html.replaceAll("%matches%", buf.toString());
    }

    private String renderAsAvailable(Session session) {
        return REPLACE_WITH_THIS.replaceAll("%name%", session.getPairName()).replaceAll("%when%", session.getTime());
    }
}
