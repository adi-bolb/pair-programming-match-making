package org.findapair;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.Request;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTests {

	@Mock
	private Request request;

	@Test
	public void createsPairingSessionFromRequest(){
		Application.PairingSession expected = new Application.PairingSession("Adi", "some date", "subject", "languages", "location");
		given(request.params("name")).willReturn(expected.name());
		given(request.params("date")).willReturn(expected.date());
		given(request.params("subject")).willReturn(expected.subject());
		given(request.params("languages")).willReturn(expected.languages());
		given(request.params("location")).willReturn(expected.location());

		Application.PairingSession pairingSession = Application.getPairingSessionForRequest(request);

		assertThat(expected, is(pairingSession));
	}

	@Test public void testPersistObject() {

		Application.PairingSession pairingSession = Application.getPairingSessionForRequest(request);
		PersistanceLayer persistanceLayer = mock(PersistanceLayer.class);
		Application.setPersistanceLayer(persistanceLayer);

		Application.addSession(request);

		verify(persistanceLayer).save(pairingSession);
	}

}
