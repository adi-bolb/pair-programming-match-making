package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.matchmaking.view.Pages.FIND_A_PAIR;

class FindPairingSessionsRoute implements Route {
	public static final String PAIRING_SESSIONS_ATTRIBUTE = "pairingSessions";
	public static final String LOCATION_PARAMETER = "location";
	private PairingSessions pairingSessions;

	@Inject
	public FindPairingSessionsRoute(PairingSessions pairingSessions) {
		this.pairingSessions = pairingSessions;
	}

	@Override
	public ModelAndView handle(Request req, Response res) {
		String location = req.queryParams(LOCATION_PARAMETER);

		List<PairingSession> matchingSessions = pairingSessions.findByLocation(location);

		Map<String, Object> attributes = new HashMap<>();
		attributes.put(PAIRING_SESSIONS_ATTRIBUTE, matchingSessions);
		return new ModelAndView(attributes, FIND_A_PAIR);
	}
}
