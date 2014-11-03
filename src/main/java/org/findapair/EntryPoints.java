package org.findapair;

import org.findapair.database.Database;
import org.findapair.email.Emailer;
import org.findapair.invitations.AcceptInvitation;
import org.findapair.invitations.InvitePair;
import org.findapair.invitations.RejectInvitation;
import org.findapair.pages.Pages;
import org.findapair.pairing.AvailablePairingSessions;
import org.findapair.pairing.Id;

public final class EntryPoints {
    private final Pages pages;

    private final InvitePair invitePair;
    private final AcceptInvitation acceptInvitation;
    private final RejectInvitation rejectInvitation;

    public EntryPoints(Pages pages, Emailer emailer, Database database) {
        this.pages = pages;

        this.invitePair = new InvitePair(pages, emailer);
        this.acceptInvitation = new AcceptInvitation(pages, emailer);
        this.rejectInvitation = new RejectInvitation(pages, emailer);
    }

    public String findAPair() {
        return pages.findAPair();
    }

    public AvailablePairingSessions availablePairs(String description) {
        return new AvailablePairingSessions();
    }

    public String invitePair(Id id) {
        return invitePair.go();
    }

    public String acceptInvitation(Id id) {
        return acceptInvitation.go();
    }

    public String rejectInvitation() {
        return rejectInvitation.go();
    }
}
