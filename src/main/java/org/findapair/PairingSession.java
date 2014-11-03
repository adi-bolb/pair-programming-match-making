package org.findapair;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class PairingSession {
	private final String name;
	private final String date;
	private final String subject;
	private final String languages;
	private final String location;

	public PairingSession(String name, String date, String subject, String languages, String location) {
		this.name = name;
		this.date = date;
		this.subject = subject;
		this.languages = languages;
		this.location = location;
	}

	public String name() {
		return name;
	}

	public String date() {
		return date;
	}

	public String subject() {
		return subject;
	}

	public String languages() {
		return languages;
	}

	public String location() {
		return location;
	}

	@Override
	public boolean equals(Object o) {
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

}
