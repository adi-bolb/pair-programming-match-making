package org.findapair.acceptance;

import org.findapair.EntryPoints;
import org.findapair.database.Database;
import org.findapair.database.InMemoryDatabase;
import org.findapair.email.Email;
import org.findapair.email.FakeEmailer;
import org.findapair.email.Inbox;
import org.findapair.invitations.Invitation;
import org.findapair.pages.Pages;
import org.findapair.pairing.AvailablePairs;
import org.findapair.pairing.Id;
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
        createAvailablePairsIncluding(aki);

        alex.searchForPair("TDD Kata");
        alex.invite("Aki Salmi");

        aki.readInvitationEmailFrom("Alex Bolboaca");
        aki.acceptInvitation();

        alex.receiveAcceptanceEmailFrom("aki@example.com");
    }

    private void createAvailablePairsIncluding(PotentialPair potentialPair) {

    }

    private static class PotentialPair {
        private final Inbox inbox;
        private final EntryPoints entryPoints;

        private AvailablePairs availablePairs;
        private Invitation invitation;

        private PotentialPair(Inbox inbox, EntryPoints entryPoints) {
            this.inbox = inbox;
            this.entryPoints = entryPoints;
        }

        public void searchForPair(String description) {
            this.availablePairs = entryPoints.availablePairs(description);
        }

        public void invite(String name) {
            Id id = availablePairs.stream().filter(pair -> pair.name().equals(name)).findFirst().get().id();
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
