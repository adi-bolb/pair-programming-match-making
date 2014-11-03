package org.findapair.email;

public class FakeEmailerToConsole implements Emailer {
	@Override
	public void sendEmail(Email email) {
		System.out.println(
				"Email:\n"
				+ "  From: " + email.from + "\n"
				+ "  To: " + email.to + "\n"
				+ "  Subject: " + email.subject + "\n"
				+ "  Body: " + email.body + "\n");
	}
}
