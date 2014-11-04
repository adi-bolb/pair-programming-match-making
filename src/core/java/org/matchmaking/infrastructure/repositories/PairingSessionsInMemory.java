package org.matchmaking.infrastructure.repositories;

import org.matchmaking.domain.PairingSession;
import org.matchmaking.domain.PairingSessions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class PairingSessionsInMemory implements PairingSessions {

	public void add(PairingSession pairingSession) {
	}

	public List<PairingSession> all() {
		throw new NotImplementedException();
	}

}
