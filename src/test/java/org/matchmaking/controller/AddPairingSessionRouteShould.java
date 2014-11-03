package org.matchmaking.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matchmaking.actions.AddPairingSession;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionFactory;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static org.matchmaking.Dummy.dummy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPairingSessionRouteShould {

	@Mock Request request;
	@Mock PairingSessionFactory pairingSessionFactory;
	@Mock AddPairingSession addPairingSession;

	private PairingSession pairingSession = dummy(PairingSession.class);
	private Response response = dummy(Response.class);

	private Map<String, String> paramsMap = new HashMap<>();
	private AddPairingSessionRoute addSessionRoute;

	@Before
	public void initialise() {
		addSessionRoute = new AddPairingSessionRoute(addPairingSession,
													 pairingSessionFactory);
	}

	@Test public void
	add_new_session() {
		given(request.params()).willReturn(paramsMap);
		given(pairingSessionFactory.create(paramsMap)).willReturn(pairingSession);

		addSessionRoute.handle(request, response);

		verify(addPairingSession).add(pairingSession);
	} 

}
