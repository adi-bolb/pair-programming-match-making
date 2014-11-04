package org.matchmaking.infrastructure.repositories;

import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class PairingSessionsInMemory implements PairingSessions {

	private List<PairingSession> pairingSessions = new ArrayList<>();

	public void add(PairingSession pairingSession) {
		pairingSessions.add(pairingSession);
	}

	public List<PairingSession> all() {
		return unmodifiableList(pairingSessions);
	}

	@Override
	public List<PairingSession> findByLocation(String location) {
		return pairingSessions.stream()
							  .filter((ps) -> location.equals(ps.getLocation()))
							  .collect(toList());
	}

}
