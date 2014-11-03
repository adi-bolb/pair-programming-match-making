package org.hardcoreretreat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.get;

public class AppLaunch {

	public static void main(String[] args) {
		get("/hello", (req, res) -> indexPage());
	}

	private static String indexPage() {
		Path indexPage;
		try {
			indexPage = Paths.get(AppLaunch.class.getClassLoader().getResource("pages/index.html").toURI());
			return new String(Files.readAllBytes(indexPage));
		} catch (URISyntaxException | IOException e) {
			throw new ThisShouldNeverHappenException(e);
		}
	}

	private static class ThisShouldNeverHappenException extends RuntimeException {
		public ThisShouldNeverHappenException(Exception cause) {
			super(cause);
		}
	}
}
