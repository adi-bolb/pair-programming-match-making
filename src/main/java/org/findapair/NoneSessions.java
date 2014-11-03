package org.findapair;

import java.util.Arrays;
import java.util.Iterator;

public class NoneSessions implements AvailableSessions {
    @Override
    public Iterator<Session> iterator() {
        return Arrays.<Session>asList().iterator();
    }
}
