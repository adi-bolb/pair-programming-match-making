package org.findapair.pages;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.findapair.pairing.AvailablePairs;

public class Pages {
	public String findAPair() {
		return loadPage("find-a-pair.html");
	}

	public String availablePairs(AvailablePairs availablePairs) {
		return loadPage("available-pairs.html");
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
        String resourceName = "pages/" + pageName;
        URL resource = classLoader.getResource(resourceName);
        if (resource == null) {
            throw new ThisShouldNeverHappenException(String.format("resource \"%s\" was null", resourceName));
        }
        return resource.toURI();
	}
}
