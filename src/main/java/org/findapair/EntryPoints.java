package org.findapair;

import java.util.Collection;
import java.util.Collections;
import org.findapair.database.Database;
import org.findapair.email.Emailer;
import org.findapair.invitations.AcceptInvitation;
import org.findapair.invitations.InvitePair;
import org.findapair.invitations.RejectInvitation;
import org.findapair.pages.Pages;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Id;
import org.findapair.pairing.Saved;

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

    public Collection<Saved<AvailablePairingSession>> availablePairs(String description) {
        return Collections.emptySet();
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
