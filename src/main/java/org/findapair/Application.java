package org.findapair;

import spark.Route;

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

		formCompatiblePut("/invitations/:id", (req, res) -> staticPage("pair-invited.html"));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> staticPage("invitation-accepted.html"));
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> staticPage("invitation-rejected.html"));
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
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
