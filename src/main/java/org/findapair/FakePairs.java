package org.findapair;

import java.util.Arrays;
import java.util.List;

public class FakePairs implements Pairs {
    @Override
    public List<Session> findFor(String whatYouWantToDo) {
        return Arrays.asList(new Session("Aki", "today"));
    }
}
