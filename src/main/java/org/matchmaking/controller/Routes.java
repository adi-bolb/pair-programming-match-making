package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.actions.InvitePair;
import org.matchmaking.infrastructure.email.Emailer;
import org.matchmaking.infrastructure.email.FakeEmailerToConsole;
import org.matchmaking.view.Pages;
import spark.ModelAndView;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import static org.matchmaking.view.Pages.FIND_A_PAIR;
import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

	private static final Object NO_ATTRIBUTES = null;
	private Pages pages;
	private AddPairingSessionRoute addPairingSessionRoute;
	private FindPairingSessionsRoute findPairingSessionsRoute;

	@Inject
	public Routes(Pages pages,
	              AddPairingSessionRoute addPairingSessionRoute,
	              FindPairingSessionsRoute findPairingSessionsRoute) {
		this.pages = pages;
		this.addPairingSessionRoute = addPairingSessionRoute;
		this.findPairingSessionsRoute = findPairingSessionsRoute;
	}

	public void initialise() {
		initialiseHomePageRoute();
		initialisePairingSessionRoutes();
		initialiseInvitationRoutes();
	}

	private void initialiseHomePageRoute() {
		get("/", (req, res) -> new ModelAndView(NO_ATTRIBUTES, FIND_A_PAIR), new FreeMarkerEngine());
	}

	private void initialiseInvitationRoutes() {
		Emailer emailer = new FakeEmailerToConsole();
		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	private void initialisePairingSessionRoutes() {
		post("/pairs",
				(req, res) -> findPairingSessionsRoute.handle(req, res),
				new FreeMarkerEngine());
		post("/sessions/add",
				(req, res) -> addPairingSessionRoute.handle(req, res),
				new FreeMarkerEngine());
	}

	private void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
