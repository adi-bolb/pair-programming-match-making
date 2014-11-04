package org.matchmaking.actions;

import com.google.inject.Inject;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;

public class AddPairingSession {
	private PairingSessions pairingSessions;

	@Inject
	public AddPairingSession(PairingSessions pairingSessions) {
		this.pairingSessions = pairingSessions;
	}

	public void add(PairingSession pairingSession) {
		pairingSessions.add(pairingSession);
	}
}
