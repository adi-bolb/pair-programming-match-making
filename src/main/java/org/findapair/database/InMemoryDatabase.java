package org.findapair.database;

import java.util.Collection;
import java.util.Collections;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Saved;

public final class InMemoryDatabase implements Database {
    @Override
    public void add(AvailablePairingSession session) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Saved<AvailablePairingSession>> list() {
        return Collections.emptyList();
    }
}
