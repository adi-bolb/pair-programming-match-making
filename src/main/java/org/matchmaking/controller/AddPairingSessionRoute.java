package org.matchmaking.controller;

import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.actions.RetrievePairingSessions;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class AddPairingSessionRoute implements Route {
	private AddPairingSession addPairingSession;
	private PairingSessionFactory pairingSessionFactory;

	public AddPairingSessionRoute(AddPairingSession addPairingSession,
	                              PairingSessionFactory pairingSessionFactory, RetrievePairingSessions retrievePairingSessions) {
		this.addPairingSession = addPairingSession;
		this.pairingSessionFactory = pairingSessionFactory;
	}

	@Override
	public ModelAndView handle(Request req, Response res) {
		PairingSession pairingSession = pairingSessionFactory.create(req.params());
		addPairingSession.add(pairingSession);
		return new ModelAndView(null, "find-a-pair.tfl");
	}
}
