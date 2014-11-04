package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.actions.InvitePair;
import org.matchmaking.infrastructure.email.Emailer;
import org.matchmaking.infrastructure.email.FakeEmailerToConsole;
import org.matchmaking.view.Pages;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

	private Pages pages;
	private AddPairingSessionRoute addPairingSessionRoute;

	@Inject
	public Routes(Pages pages,
	              AddPairingSessionRoute addPairingSessionRoute) {
		this.pages = pages;
		this.addPairingSessionRoute = addPairingSessionRoute;
	}

	public void initialise() {
		initialiseHomePageRoute();
		initialisePairingSessionRoutes();
		initialiseInvitationRoutes();
	}

	private void initialiseHomePageRoute() {
		get("/", (req, res) -> pages.findAPair());
	}

	private void initialiseInvitationRoutes() {
		Emailer emailer = new FakeEmailerToConsole();
		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	private void initialisePairingSessionRoutes() {
		post("/pairs", (req, res) -> pages.availablePairs());
		post("/sessions/add",
				(req, res) -> {
					System.out.println("** Lambda **");
					System.out.println(req.queryParams());
					System.out.println(req.queryParams("developerName"));
					System.out.println("** Lambda **");
					return addPairingSessionRoute.handle(req, res);
				},
				new FreeMarkerEngine());
	}

	private void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
