package org.findapair.database;

import java.util.Collection;
import java.util.HashSet;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Id;
import org.findapair.pairing.Saved;

public final class InMemoryDatabase implements Database {
    private final Collection<Saved<AvailablePairingSession>> sessions = new HashSet<>();
    private int nextId = 0;

    @Override
    public void add(AvailablePairingSession session) {
        sessions.add(new Saved<>(nextId(), session));
    }

    @Override
    public Collection<Saved<AvailablePairingSession>> list() {
        return sessions;
    }

    private Id nextId() {
        nextId += 1;
        return new Id(nextId);
    }
}
