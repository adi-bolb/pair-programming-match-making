package org.findapair;


import java.util.Arrays;
import java.util.Iterator;

public class SomeSessions implements  AvailableSessions{
    private final Session[] sessions;

    public SomeSessions(Session... sessions) {
        this.sessions = sessions;
    }

    @Override
    public Iterator<Session> iterator() {
        return Arrays.asList(sessions).iterator();
    }
}
