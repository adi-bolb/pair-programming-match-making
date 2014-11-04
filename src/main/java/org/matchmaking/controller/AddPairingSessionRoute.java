package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.actions.RetrievePairingSessions;
import org.matchmaking.domain.PairingSession;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.matchmaking.view.Pages.FIND_A_PAIR;

public class AddPairingSessionRoute implements Route {
	private AddPairingSession addPairingSession;
	private PairingSessionFactory pairingSessionFactory;
	private RetrievePairingSessions retrievePairingSessions;

	@Inject
	public AddPairingSessionRoute(AddPairingSession addPairingSession,
	                              PairingSessionFactory pairingSessionFactory,
	                              RetrievePairingSessions retrievePairingSessions) {
		this.addPairingSession = addPairingSession;
		this.pairingSessionFactory = pairingSessionFactory;
		this.retrievePairingSessions = retrievePairingSessions;
	}

	@Override
	public ModelAndView handle(Request req, Response res) {
		PairingSession pairingSession = pairingSessionFactory.create(req);
		addPairingSession.add(pairingSession);

		List<PairingSession> availablePairingSessions = retrievePairingSessions.all();

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("pairingSessions", availablePairingSessions);
		ModelAndView modelAndView = new ModelAndView(attributes, FIND_A_PAIR);

		return modelAndView;
	}
}
