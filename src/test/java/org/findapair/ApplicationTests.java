package org.findapair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.ModelAndView;
import spark.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.findapair.Application.FIND_A_PAIR_TEMPLATE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTests {

	@Mock
	private Request request;
	private PersistanceLayer persistanceLayer;
	public static final List<PairingSession> PAIRING_SESSIONS = new ArrayList<>();

	@Before
	public void initialise() {
		persistanceLayer = mock(PersistanceLayer.class);
		Application.setPersistanceLayer(persistanceLayer);
	}

	@Test
	public void createsPairingSessionFromRequest(){
		PairingSession expected = new PairingSession("Adi", "some date", "subject", "languages", "location");
		given(request.params("name")).willReturn(expected.getName());
		given(request.params("date")).willReturn(expected.date());
		given(request.params("subject")).willReturn(expected.subject());
		given(request.params("languages")).willReturn(expected.languages());
		given(request.params("location")).willReturn(expected.location());

		PairingSession pairingSession = Application.getPairingSessionForRequest(request);

		assertThat(expected, is(pairingSession));
	}

	@Test public void persistsPairingSession() {
		PairingSession pairingSession = Application.getPairingSessionForRequest(request);

		Application.addSession(request);

		verify(persistanceLayer).save(pairingSession);
	}

	@Test public void showAllPairingSessions() {
		given(persistanceLayer.getAllPairingSessions()).willReturn(PAIRING_SESSIONS);

		ModelAndView actual = Application.addNewPairingSession(request);

		assertThat(((Map <String, Object>) actual.getModel()).get("pairingSessions"), is(PAIRING_SESSIONS));
	}

	@Test public void returnsToTheSamePageWhenCreatingPairingSession() {
		ModelAndView actual = Application.addNewPairingSession(request);

		assertThat(actual.getViewName(), is(FIND_A_PAIR_TEMPLATE));
	}
}