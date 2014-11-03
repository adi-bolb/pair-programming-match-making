package org.matchmaking.infrastructure.email;

public class InvitationEmail {
	public static Email make() {
		String from = "samir@samir.com";
		String to = "peter@peter.com";
		String subject = "Invitation Subject";
		String body =
				"Accept: http://localhost:4567/invitations/1/accept\n"
			  + "Reject: http://localhost:4567/invitations/1/reject\n";
		return new Email(from, to, subject, body);
	}
}
