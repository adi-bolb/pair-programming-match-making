package org.matchmaking.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class PairingSession {
	private final String developerName;
	private final String date;
	private final String subject;
	private final String languages;
	private final String location;

	public PairingSession(String developerName, String date, String subject, String languages, String location) {
		this.developerName = developerName;
		this.date = date;
		this.subject = subject;
		this.languages = languages;
		this.location = location;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public String getDate() {
		return date;
	}

	public String getSubject() {
		return subject;
	}

	public String getLanguages() {
		return languages;
	}

	public String getLocation() {
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

	@Override
	public String toString() {
		return "PairingSession{" +
				"developerName='" + developerName + '\'' +
				", date='" + date + '\'' +
				", subject='" + subject + '\'' +
				", languages='" + languages + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}
