package org.findapair.acceptance;

import java.util.Collection;
import org.findapair.EntryPoints;
import org.findapair.database.Database;
import org.findapair.database.InMemoryDatabase;
import org.findapair.email.Email;
import org.findapair.email.FakeEmailer;
import org.findapair.email.Inbox;
import org.findapair.invitations.Invitation;
import org.findapair.pages.Pages;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Id;
import org.findapair.pairing.Saved;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@Ignore("Pending")
public final class FindAPairSpecification {
    private final Pages pages = mock(Pages.class);
    private final FakeEmailer emailer = new FakeEmailer();
    private final Database database = new InMemoryDatabase();

    @Test public void
    findsAPairWhenAvailable() {
        PotentialPair aki = new PotentialPair(emailer.inboxOf("aki@example.com"), new EntryPoints(pages, emailer, database));
        PotentialPair alex = new PotentialPair(emailer.inboxOf("alex@example.com"), new EntryPoints(pages, emailer, database));
        createAvailablePairingSessionsIncluding(new AvailablePairingSession("Aki Salmi", "I want to work on TDD, specifically the bowling score kata."));

        alex.searchForPair("TDD Kata");
        alex.invite("Aki Salmi");

        aki.readInvitationEmailFrom("Alex Bolboaca");
        aki.acceptInvitation();

        alex.receiveAcceptanceEmailFrom("aki@example.com");
    }

    private void createAvailablePairingSessionsIncluding(AvailablePairingSession session) {
        throw new UnsupportedOperationException();
    }

    private static class PotentialPair {
        private final Inbox inbox;
        private final EntryPoints entryPoints;

        private Collection<Saved<AvailablePairingSession>> availablePairingSessions;
        private Invitation invitation;

        private PotentialPair(Inbox inbox, EntryPoints entryPoints) {
            this.inbox = inbox;
            this.entryPoints = entryPoints;
        }

        public void searchForPair(String description) {
            this.availablePairingSessions = entryPoints.availablePairs(description);
        }

        public void invite(String name) {
            Id id = availablePairingSessions.stream().filter(pair -> pair.value().programmerName().equals(name)).findFirst().get().id();
            entryPoints.invitePair(id);
        }

        public void readInvitationEmailFrom(String name) {
            Email email = inbox.readEmailFrom(name);
            invitation = Invitation.fromEmail(email);
        }

        public void acceptInvitation() {
            Id id = invitation.id();
            entryPoints.acceptInvitation(id);
        }

        public void receiveAcceptanceEmailFrom(String emailAddress) {
            Email email = inbox.readEmailFrom(emailAddress);
            assertThat(email, is(notNullValue()));
        }
    }
}
