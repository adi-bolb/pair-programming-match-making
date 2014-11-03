package org.findapair.pairing;

import java.util.Iterator;
import java.util.stream.Stream;

public final class AvailablePairs implements Iterable<AvailablePair> {
    @Override
    public Iterator<AvailablePair> iterator() {
        throw new UnsupportedOperationException();
    }

    public Stream<AvailablePair> stream() {
        throw new UnsupportedOperationException();
    }
}
