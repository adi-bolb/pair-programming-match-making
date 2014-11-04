package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;
import org.matchmaking.view.Pages;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindPairingSessionsRoute implements Route {
	private Pages pages;
	private PairingSessions pairingSessions;

	@Inject
	public FindPairingSessionsRoute(Pages pages, PairingSessions pairingSessions) {
		this.pages = pages;
		this.pairingSessions = pairingSessions;
	}

	@Override
	public ModelAndView handle(Request req, Response res) {
		String location = req.queryParams("location");
		List<PairingSession> matchingSessions = pairingSessions.findByLocation(location);

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("pairingSessions", matchingSessions);
		return new ModelAndView(attributes, null);
	}
}
