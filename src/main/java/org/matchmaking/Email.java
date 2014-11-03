package org.matchmaking;

import java.util.Objects;

public class Email {
	public final String from;
	public final String to;
	public final String subject;
	public final String body;

	public Email(String from, String to, String subject, String body) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Email email = (Email) o;

		if (!body.equals(email.body)) return false;
		if (!from.equals(email.from)) return false;
		if (!subject.equals(email.subject)) return false;
		if (!to.equals(email.to)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to, subject, body);
	}
}
