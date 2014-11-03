package org.matchmaking.controller;

import org.matchmaking.infrastructure.email.Emailer;
import org.matchmaking.infrastructure.email.FakeEmailerToConsole;
import org.matchmaking.actions.InvitePair;
import org.matchmaking.view.Pages;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

	public void initialise() {
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();

		get("/", (req, res) -> pages.findAPair());
		post("/pairs", (req, res) -> pages.availablePairs());
		post("/sessions/add", new AddSessionRoute());

		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	private void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
