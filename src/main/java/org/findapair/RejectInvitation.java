package org.findapair;

import spark.Request;
import spark.Response;
import spark.Route;

public class RejectInvitation implements Route {
    private final Pages pages;
    private final Emailer emailer;

    public RejectInvitation(Pages pages, Emailer emailer) {
        this.pages = pages;
        this.emailer = emailer;
    }

    @Override
    public Object handle(Request req, Response res) {
        emailer.sendEmail(Emails.RejectionEmail.make());
        return pages.invitationRejected();
    }
}
