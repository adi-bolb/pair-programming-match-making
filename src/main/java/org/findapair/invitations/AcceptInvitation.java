package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;

public class AcceptInvitation {
    private final Pages pages;
    private final Emailer emailer;

    public AcceptInvitation(Pages pages, Emailer emailer) {
        this.pages = pages;
        this.emailer = emailer;
    }

    public String go() {
        emailer.sendEmail(Emails.AcceptanceEmail.make());
        return pages.invitationAccepted();
    }
}
