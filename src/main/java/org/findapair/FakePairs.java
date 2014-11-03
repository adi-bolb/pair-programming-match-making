package org.findapair;

import java.util.Arrays;
import java.util.List;

public class FakePairs implements Pairs {
    @Override
    public List<Pair> findPairs(String whatYouWantToDo) {
        return Arrays.asList(new Pair("Aki"));
    }
}
