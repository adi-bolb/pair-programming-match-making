package org.findapair.pairing;

import java.util.Iterator;
import java.util.stream.Stream;

public final class AvailablePairingSessions implements Iterable<AvailablePairingSession> {
    @Override
    public Iterator<AvailablePairingSession> iterator() {
        throw new UnsupportedOperationException();
    }

    public Stream<AvailablePairingSession> stream() {
        throw new UnsupportedOperationException();
    }
}
