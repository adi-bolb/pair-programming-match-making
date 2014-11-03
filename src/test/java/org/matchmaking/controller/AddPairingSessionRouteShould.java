package org.matchmaking.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.actions.RetrievePairingSessions;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionFactory;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.matchmaking.Dummy.dummy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPairingSessionRouteShould {

	private static final List<PairingSession> ALL_PAIRING_SESSIONS = new ArrayList<>();

	@Mock Request request;
	@Mock PairingSessionFactory pairingSessionFactory;
	@Mock AddPairingSession addPairingSession;
	@Mock RetrievePairingSessions retrievePairingSessions;

	private PairingSession pairingSession = dummy(PairingSession.class);
	private Response response = dummy(Response.class);

	private Map<String, String> paramsMap = new HashMap<>();
	private AddPairingSessionRoute addSessionRoute;

	@Before
	public void initialise() {
		addSessionRoute = new AddPairingSessionRoute(addPairingSession,
													 pairingSessionFactory,
													 retrievePairingSessions);
	}

	@Test public void
	add_new_session() {
		given(request.params()).willReturn(paramsMap);
		given(pairingSessionFactory.create(paramsMap)).willReturn(pairingSession);

		addSessionRoute.handle(request, response);

		verify(addPairingSession).add(pairingSession);
	}

	@Test public void
	display_home_page_after_adding_a_new_pairing_session() {
		ModelAndView viewModel = addSessionRoute.handle(request, response);

		assertThat(viewModel.getViewName(), is("find-a-pair.tfl"));
	}

	@Test public void
	display_list_of_available_pairing_sessions_on_home_page() {
		given(retrievePairingSessions.all()).willReturn(ALL_PAIRING_SESSIONS);

		ModelAndView viewModel = addSessionRoute.handle(request, response);

		Map<String, Object> modelAttributes = (Map<String, Object>) viewModel.getModel();
		assertThat(modelAttributes.get("pairingSessions"), is(ALL_PAIRING_SESSIONS));
	}

}
