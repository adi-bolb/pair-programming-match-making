package org.findapair;

import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {

		createRoutes();
	}

	private static void createRoutes() {
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();

		get("/", (req, res) -> pages.findAPair());
		post("/pairs", (req, res) -> pages.availablePairs());
		post("/sessions/add", (req, res) -> null);

		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
