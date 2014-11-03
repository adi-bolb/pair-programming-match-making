package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;

public class InvitePair {
	private final Pages pages;
	private Emailer emailer;

	public InvitePair(Pages pages, Emailer emailer) {
		this.pages = pages;
		this.emailer = emailer;
	}

    public String go() {
		emailer.sendEmail(Emails.InvitationEmail.make());
		return pages.pairHasBeenInvited();
	}
}
