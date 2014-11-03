package org.findapair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.get;

public class Application {

	public static void main(String[] args) {
		get("/", (req, res) -> indexPage());
	}

	private static String indexPage() {
		try {

			URI indexUri = Application.class.getClassLoader().getResource("pages/index.html").toURI();
			Path indexPage = Paths.get(indexUri);
			return new String(Files.readAllBytes(indexPage));

		} catch (URISyntaxException | IOException e) {
			throw new ThisShouldNeverHappenException(e);
		}
	}

}
