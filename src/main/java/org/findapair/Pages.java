package org.findapair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pages {

    public static final String REPLACE_WITH_THIS = "<tr>\n" +
            "\t<td>%name%</td>\n" +
            "\t<td>%when%</td>\n" +
            "\t<td>\n" +
            "\t\t<form action=\"/invitations/%id%\" method=\"post\">\n" +
            "\t\t<input type=\"submit\" value=\"Let's pair\" />\n" +
            "\t\t</form>\n" +
            "\t</td>\n" +
            "</tr>\n";

    public String findAPair() {
		return loadPage("find-a-pair.html");
	}

	public String renderAsAvailable(AvailableSessions availableSessions) {
        StringBuilder buf = new StringBuilder();
        for (Session session : availableSessions) {
            buf.append(renderAsAvailable(session));
        }
        final String html = loadPage("available-pairs.html");
        return html.replaceAll("%matches%", buf.toString());
	}

    private String renderAsAvailable(Session session) {
        return REPLACE_WITH_THIS.replaceAll("%name%", session.getPairName()).replaceAll("%when%", session.getTime());
    }

    public String pairHasBeenInvited() {
		return loadPage("pair-invited.html");
	}

	public String invitationAccepted() {
		return loadPage("invitation-accepted.html");
	}

	public String invitationRejected() {
		return loadPage("invitation-rejected.html");
	}

	private String loadPage(String pageName) {
		try {
			URI pageUri = getPageResource(pageName);
			Path pagePath = Paths.get(pageUri);
			return new String(Files.readAllBytes(pagePath));

		} catch (URISyntaxException | IOException e) {
			throw new ThisShouldNeverHappenException(e);
		}
	}

	private URI getPageResource(String pageName) throws URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource("pages/" + pageName).toURI();
	}

    public Page getAvailableSessionsPage(AvailableSessions foundSessions) {
        return new AvailableSessionsPage();
    }
}