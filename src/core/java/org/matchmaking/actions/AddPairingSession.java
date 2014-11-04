package org.matchmaking.actions;

import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionRepository;

public class AddPairingSession {
	private PairingSessionRepository pairingSessionRepository;

	public AddPairingSession(PairingSessionRepository pairingSessionRepository) {
		this.pairingSessionRepository = pairingSessionRepository;
	}

	public void add(PairingSession pairingSession) {
		pairingSessionRepository.add(pairingSession);
	}
}
