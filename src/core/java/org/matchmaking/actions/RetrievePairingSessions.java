package org.matchmaking.actions;

import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionRepository;

import java.util.List;

public class RetrievePairingSessions {
	private PairingSessionRepository pairingSessionRepository;

	public RetrievePairingSessions(PairingSessionRepository pairingSessionRepository) {
		this.pairingSessionRepository = pairingSessionRepository;
	}

	public List<PairingSession> all() {
		return pairingSessionRepository.all();
	}
}
