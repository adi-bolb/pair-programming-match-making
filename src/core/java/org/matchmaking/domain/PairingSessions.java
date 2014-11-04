package org.matchmaking.domain;

import java.util.List;

public interface PairingSessions {

	void add(PairingSession pairingSession);

	List<PairingSession> all();
}
