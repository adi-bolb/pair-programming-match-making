package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;
import spark.Request;
import spark.Response;
import spark.Route;

public class InvitePair implements Route {
	private final Pages pages;
	private Emailer emailer;

	public InvitePair(Pages pages, Emailer emailer) {
		this.pages = pages;
		this.emailer = emailer;
	}

	@Override
	public Object handle(Request req, Response res)  {

		emailer.sendEmail(Emails.InvitationEmail.make());
		return pages.pairHasBeenInvited();
	}
}
