package org.matchmaking.controller;

import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.actions.RetrievePairingSessions;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class AddPairingSessionRoute implements Route {
	private AddPairingSession addPairingSession;
	private PairingSessionFactory pairingSessionFactory;
	private RetrievePairingSessions retrievePairingSessions;

	public AddPairingSessionRoute(AddPairingSession addPairingSession,
	                              PairingSessionFactory pairingSessionFactory,
	                              RetrievePairingSessions retrievePairingSessions) {
		this.addPairingSession = addPairingSession;
		this.pairingSessionFactory = pairingSessionFactory;
		this.retrievePairingSessions = retrievePairingSessions;
	}

	@Override
	public ModelAndView handle(Request req, Response res) {
		PairingSession pairingSession = pairingSessionFactory.create(req.params());
		addPairingSession.add(pairingSession);

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("pairingSessions", retrievePairingSessions.all());
		return new ModelAndView(attributes, "find-a-pair.tfl");
	}
}
