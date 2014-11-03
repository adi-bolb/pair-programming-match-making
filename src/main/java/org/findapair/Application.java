package org.findapair;

import org.findapair.database.Database;
import org.findapair.database.InMemoryDatabase;
import org.findapair.email.Emailer;
import org.findapair.email.FakeEmailerToConsole;
import org.findapair.pages.Pages;
import org.findapair.pairing.Id;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();
        Database database = new InMemoryDatabase();

        EntryPoints entryPoints = new EntryPoints(pages, emailer, database);

		get("/", (req, res) ->
                entryPoints.findAPair());
		post("/pairs", (req, res) ->
                pages.availablePairs(entryPoints.availablePairs(req.queryParams("description"))));

		formCompatiblePut("/invitations/:id", (req, res) ->
                entryPoints.invitePair(Id.from(req.params("id"))));
		emailCompatiblePost("/invitations/:id/accept", (req, res) ->
                entryPoints.acceptInvitation(Id.from(req.params("id"))));
        emailCompatiblePost("/invitations/:id/reject", (req, res) ->
                entryPoints.rejectInvitation());
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
