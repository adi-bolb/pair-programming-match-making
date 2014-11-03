package org.findapair;

import spark.Request;
import spark.Response;
import spark.Route;

class InvitePair implements Route {
	private final Pages pages;
	private Emailer emailer;

	public InvitePair(Pages pages, Emailer emailer) {
		this.pages = pages;
		this.emailer = emailer;
	}

	@Override
	public Object handle(Request req, Response res)  {

		emailer.sendEmail();
		return pages.pairHasBeenInvited();
	}
}
