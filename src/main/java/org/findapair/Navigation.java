package org.findapair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Navigation {
	public String home() {
		return staticPage("index.html");
	}

	public String availablePairs() {
		return staticPage("pairs.html");
	}

	public String pairHasBeenInvited() {
		return staticPage("pair-invited.html");
	}

	public String invitationAccepted() {
		return staticPage("invitation-accepted.html");
	}

	public String invitationRejected() {
		return staticPage("invitation-rejected.html");
	}

	private static String staticPage(String pageName) {
		try {

			URI indexUri = Application.class.getClassLoader().getResource("pages/"+ pageName).toURI();
			Path indexPage = Paths.get(indexUri);
			return new String(Files.readAllBytes(indexPage));

		} catch (URISyntaxException | IOException e) {
			throw new ThisShouldNeverHappenException(e);
		}
	}
}
