package org.findapair;

public class InvitationEmail {
	public static Email make() {
		String from = "samir@samir.com";
		String to = "peter@peter.com";
		String subject = "Invitation Subject";
		String body = "Body message";
		return new Email(from, to, subject, body);
	}
}
