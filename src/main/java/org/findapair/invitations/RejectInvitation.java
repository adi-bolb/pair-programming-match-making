package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;

public class RejectInvitation {
    private final Pages pages;
    private final Emailer emailer;

    public RejectInvitation(Pages pages, Emailer emailer) {
        this.pages = pages;
        this.emailer = emailer;
    }

    public String go() {
        emailer.sendEmail(Emails.RejectionEmail.make());
        return pages.invitationRejected();
    }
}
