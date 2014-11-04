package org.matchmaking.actions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionRepository;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.matchmaking.infrastructure.builders.PairingSessionBuilder.aPairingSession;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPairingSessionShould {

	@Mock PairingSessionRepository pairingSessionRepository;

	private AddPairingSession addPairingSession;

	@Before
	public void initialise() {
	    addPairingSession = new AddPairingSession(pairingSessionRepository);
	}

	@Test public void
	add_new_pairing_session() {
		PairingSession pairingSession = aPairingSession().build();

		addPairingSession.add(pairingSession);

		verify(pairingSessionRepository).add(pairingSession);
	}
}
