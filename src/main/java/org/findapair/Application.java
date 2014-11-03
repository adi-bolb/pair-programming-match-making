package org.findapair;

import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {
		Navigation navigation = new Navigation();

		get("/", (req, res) -> navigation.findAPair());
		post("/pairs", (req, res) -> navigation.availablePairs());

		formCompatiblePut("/invitations/:id", (req, res) -> navigation.pairHasBeenInvited());
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> navigation.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> navigation.invitationRejected());
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
