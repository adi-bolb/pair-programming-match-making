package org.matchmaking.infrastructure.builders;

import org.matchmaking.domain.PairingSession;

public class PairingSessionBuilder {
	private String developerName = "Joe Blogs";
	private String date = "04/11/2014";
	private String subject = "Some subject";
	private String languages = "Java, C#";
	private String location = "Central London";

	public static PairingSessionBuilder aPairingSession() {
		return new PairingSessionBuilder();
	}

	public PairingSessionBuilder withDeveloperName(String developerName) {
		this.developerName = developerName;
		return this;
	}

	public PairingSessionBuilder withDate(String date) {
		this.date = date;
		return this;
	}

	public PairingSessionBuilder withSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public PairingSessionBuilder withLanguages(String languages) {
		this.languages = languages;
		return this;
	}

	public PairingSessionBuilder withLocation(String location) {
		this.location = location;
		return this;
	}

	public PairingSession build() {
		return new PairingSession(developerName, date, subject, languages, location);
	}
}
