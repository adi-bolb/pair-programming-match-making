package org.matchmaking.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;
import org.matchmaking.view.Pages;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.matchmaking.infrastructure.builders.PairingSessionBuilder.aPairingSession;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FindPairingSessionsRouteShould {

	private static final String LOCATION = "Some location";

	@Mock PairingSessions pairingSessions;
	@Mock Request request;
	@Mock Response response;
	@Mock Pages pages;

	private List<PairingSession> PAIRING_SESSIONS = new ArrayList<>();

	private FindPairingSessionsRoute findPairingSessionsRoute;

	@Before
	public void initialise() {
		PAIRING_SESSIONS.add(aPairingSession().build());
	    findPairingSessionsRoute = new FindPairingSessionsRoute(pages, pairingSessions);
	}

	@Test public void
	return_pairing_sessions_with_matching_locations() {
		given(request.queryParams("location")).willReturn(LOCATION);
		given(pairingSessions.findByLocation(LOCATION)).willReturn(PAIRING_SESSIONS);

		ModelAndView modelAndView = findPairingSessionsRoute.handle(request, response);

		Map<String, Object> modelAndViewAttributes = (Map<String, Object>) modelAndView.getModel();

		assertThat(modelAndViewAttributes.get("pairingSessions"), is(PAIRING_SESSIONS));
	}



}