package org.findapair.database;

import java.util.Collection;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Saved;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryDatabaseTest {

    @Test
    public void initialDatabaseIsEmpty(){
        InMemoryDatabase database = new InMemoryDatabase();

        assertThat(database.list(), is(empty()));
    }

    private static Matcher<Collection<? extends Saved<AvailablePairingSession>>> empty() {
        return Matchers.<Saved<AvailablePairingSession>>empty();
    }
}
