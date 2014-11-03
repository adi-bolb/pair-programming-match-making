package org.findapair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {
		get("/", (req, res) -> staticPage("index.html"));
		post("/pairs", (req, res) -> staticPage("pairs.html"));
		post("/pairs/:name/:id", (req, res) -> staticPage("pair-notified.html"));

		get("/invitations/:id/accept", (req, res) -> staticPage("invitation-accepted.html"));
		get("/invitations/:id/reject", (req, res) -> staticPage("invitation-rejected.html"));
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
