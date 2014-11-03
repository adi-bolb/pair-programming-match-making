package org.findapair.database;

import org.findapair.pairing.AvailablePairingSession;

public interface Database {
    void add(AvailablePairingSession session);
}
