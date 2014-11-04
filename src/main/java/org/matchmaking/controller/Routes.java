package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.actions.InvitePair;
import org.matchmaking.actions.RetrievePairingSessions;
import org.matchmaking.domain.PairingSessionFactory;
import org.matchmaking.infrastructure.email.Emailer;
import org.matchmaking.infrastructure.email.FakeEmailerToConsole;
import org.matchmaking.view.Pages;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

	private Pages pages;
	private AddPairingSession addPairingSession;
	private PairingSessionFactory pairingSessionFactory;
	private RetrievePairingSessions retrievePairingSessions;

	@Inject
	public Routes(Pages pages,
				  AddPairingSession addPairingSession,
	              PairingSessionFactory pairingSessionFactory,
	              RetrievePairingSessions retrievePairingSessions) {
		this.pages = pages;
		this.addPairingSession = addPairingSession;
		this.pairingSessionFactory = pairingSessionFactory;
		this.retrievePairingSessions = retrievePairingSessions;
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
				(req, res) -> new AddPairingSessionRoute(addPairingSession,
														pairingSessionFactory,
														retrievePairingSessions)
											.handle(req, res),
				new FreeMarkerEngine());
	}

	private void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

}
