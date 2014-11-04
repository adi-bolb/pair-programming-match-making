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

	    assertThat(pairingSessions.size(), is(2));
		assertThat(pairingSessions.get(0), is(SOME_PAIRING_SESSION));
		assertThat(pairingSessions.get(1), is(ANOTHER_PAIRING_SESSION));
	}
}
