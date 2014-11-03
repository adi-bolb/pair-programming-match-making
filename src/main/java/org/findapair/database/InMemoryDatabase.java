package org.findapair.database;

import org.findapair.pairing.AvailablePairingSession;

public final class InMemoryDatabase implements Database {
    @Override
    public void add(AvailablePairingSession session) {
        throw new UnsupportedOperationException();
    }
}
