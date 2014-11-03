package org.findapair.database;

import java.util.Collection;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Saved;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class InMemoryDatabaseTest {
    private final InMemoryDatabase database = new InMemoryDatabase();

    @Test
    public void initialDatabaseIsEmpty() {
        assertThat(database.list(), is(empty()));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void theDatabaseContainsEverythingYouPutInIt() {
        AvailablePairingSession sessionA = new AvailablePairingSession("Alex", "Hi!");
        AvailablePairingSession sessionB = new AvailablePairingSession("Bob", "Hello!");
        AvailablePairingSession sessionC = new AvailablePairingSession("Charlie", "Woop!");

        database.add(sessionA);
        database.add(sessionB);
        database.add(sessionC);

        assertThat(database.list(), containsInAnyOrder(saved(sessionA), saved(sessionB), saved(sessionC)));
    }

    private static Matcher<Collection<? extends Saved<AvailablePairingSession>>> empty() {
        return Matchers.<Saved<AvailablePairingSession>>empty();
    }

    private static <T> Matcher<Saved<T>> saved(T value) {
        return new FeatureMatcher<Saved<T>, T>(sameInstance(value), "value", "value") {
            @Override protected T featureValueOf(Saved<T> saved) {
                return saved.value();
            }
        };
    }
}
