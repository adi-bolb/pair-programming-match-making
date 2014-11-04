package org.matchmaking.actions;

import com.google.inject.Inject;
import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;

import java.util.List;

public class RetrievePairingSessions {
	private PairingSessions pairingSessions;

	@Inject
	public RetrievePairingSessions(PairingSessions pairingSessions) {
		this.pairingSessions = pairingSessions;
	}

	public List<PairingSession> all() {
		return pairingSessions.all();
	}
}
