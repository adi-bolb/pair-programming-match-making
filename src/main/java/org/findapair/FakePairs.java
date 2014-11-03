package org.findapair;

public class FakePairs implements Pairs {
    @Override
    public AvailableSessions findFor(String whatYouWantToDo) {
        return new SomeSessions(new Session("Aki", "20 - 21 today"), new Session("Peter", "19 - 20 today") );
    }
}
