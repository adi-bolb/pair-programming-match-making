package org.findapair;

import java.util.List;

public interface PersistanceLayer {
	void save(PairingSession pairingSession);

	List<PairingSession> getAllPairingSessions();
}
