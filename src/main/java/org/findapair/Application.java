package org.findapair;

import org.findapair.email.Emailer;
import org.findapair.email.FakeEmailerToConsole;
import org.findapair.invitations.AcceptInvitation;
import org.findapair.invitations.InvitePair;
import org.findapair.invitations.RejectInvitation;
import org.findapair.pages.Pages;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();

		get("/", (req, res) -> pages.findAPair());
		post("/pairs", (req, res) -> pages.availablePairs());

		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", new AcceptInvitation(pages, emailer));
        emailCompatiblePost("/invitations/:id/reject", new RejectInvitation(pages, emailer));
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
