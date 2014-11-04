package org.findapair;

import org.findapair.pages.AvailableSessionsPage;
import org.findapair.pages.NoSessionsFoundPage;
import org.findapair.pages.Page;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class PagesTest {

    @Test
    public void shouldLoadAvailableSessionsPageWhenThereAreSessions() throws Exception {
        Pages pages = new Pages();

        AvailableSessions foundSessions = new SomeSessions(new Session("name", "12:00"));
        Page availableSessionsPage = pages.getSessionsPage(foundSessions);

        assertThat(availableSessionsPage, instanceOf(AvailableSessionsPage.class));

    }

    @Test
    public void shouldLoadNoSessionsPageWhenThereAreNoSessions() throws Exception {
        Pages pages = new Pages();

        AvailableSessions foundSessions = new NoneSessions();
        Page availableSessionsPage = pages.getSessionsPage(foundSessions);

        assertThat(availableSessionsPage, instanceOf(NoSessionsFoundPage.class));
    }

}