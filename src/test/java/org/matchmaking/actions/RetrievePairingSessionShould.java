package org.matchmaking.actions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RetrievePairingSessionShould {

	private static final List<PairingSession> ALL_PAIRING_SESSIONS = new ArrayList<>();

	@Mock
	PairingSessions pairingSessions;

	private RetrievePairingSessions retrievePairingSessions;

	@Before
	public void initialise() {
	    retrievePairingSessions = new RetrievePairingSessions(pairingSessions);
	}

	@Test public void
	return_all_pairing_sessions() {
		given(pairingSessions.all()).willReturn(ALL_PAIRING_SESSIONS);

		List<PairingSession> pairingSessions = retrievePairingSessions.all();

		assertThat(pairingSessions, is(ALL_PAIRING_SESSIONS));
	}
}
