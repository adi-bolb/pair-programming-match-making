package org.matchmaking.actions;

import com.google.inject.Inject;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessionRepository;

public class AddPairingSession {
	private PairingSessionRepository pairingSessionRepository;

	@Inject
	public AddPairingSession(PairingSessionRepository pairingSessionRepository) {
		this.pairingSessionRepository = pairingSessionRepository;
	}

	public void add(PairingSession pairingSession) {
		pairingSessionRepository.add(pairingSession);
	}
}
