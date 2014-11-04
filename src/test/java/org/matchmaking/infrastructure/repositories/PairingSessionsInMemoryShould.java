package org.matchmaking.infrastructure.repositories;

import org.junit.Before;
import org.junit.Test;
import org.matchmaking.domain.PairingSession;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.matchmaking.infrastructure.builders.PairingSessionBuilder.aPairingSession;

public class PairingSessionsInMemoryShould {

	private static final PairingSession SOME_PAIRING_SESSION = aPairingSession().build();
	private static final PairingSession ANOTHER_PAIRING_SESSION = aPairingSession().build();
	private static final String LONDON = "London";
	private static final PairingSession SESSION_IN_LONDON = aPairingSession().withLocation(LONDON).build();
	private static final PairingSession SESSION_IN_SAO_PAULO = aPairingSession().withLocation("Sao Paulo").build();
	private static final PairingSession SESSION_IN_BUCHAREST = aPairingSession().withLocation("Bucharest").build();

	private PairingSessionsInMemory pairingSessionsInMemory;

	@Before
	public void initialise() {
	    pairingSessionsInMemory = new PairingSessionsInMemory();
	}

	@Test public void
	return_all_pairing_sessions() {
		pairingSessionsInMemory.add(SOME_PAIRING_SESSION);
		pairingSessionsInMemory.add(ANOTHER_PAIRING_SESSION);

		List<PairingSession> pairingSessions = pairingSessionsInMemory.all();

		assertThat(pairingSessions.contains(SOME_PAIRING_SESSION), is(true));
		assertThat(pairingSessions.contains(ANOTHER_PAIRING_SESSION), is(true));
	}

	@Test public void
	return_pairing_sessions_matching_a_given_location() {
		pairingSessionsInMemory.add(SESSION_IN_SAO_PAULO);
		pairingSessionsInMemory.add(SESSION_IN_LONDON);
		pairingSessionsInMemory.add(SESSION_IN_BUCHAREST);

		List<PairingSession> sessions = pairingSessionsInMemory.findByLocation(LONDON);

		assertThat(sessions.contains(SESSION_IN_LONDON), is(true));
	    assertThat(sessions.contains(SESSION_IN_SAO_PAULO), is(false));
	    assertThat(sessions.contains(SESSION_IN_BUCHAREST), is(false));
	}

	@Test public void
	not_return_any_pairing_sessions_when_they_dont_have_a_matching_location() {
		pairingSessionsInMemory.add(SESSION_IN_LONDON);
		pairingSessionsInMemory.add(SESSION_IN_BUCHAREST);

		List<PairingSession> sessions = pairingSessionsInMemory.findByLocation("Non-existent location");

		assertThat(sessions.isEmpty(), is(true));
	}
}
