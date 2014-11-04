package org.matchmaking.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.matchmaking.infrastructure.builders.PairingSessionBuilder.aPairingSession;

public class PairingSessionFactoryShould {

	private static final String DEVELOPER_NAME = "Sandro";
	private static final String DATE = "04/11/2014";
	private static final String SUBJECT = "Subject";
	private static final String LANGUAGES = "Java, C#, Ruby";
	private static final String LOCATION = "Central London";

	private PairingSessionFactory pairingSessionFactory = new PairingSessionFactory();

	@Test public void
	create_a_pairing_session() {
		Map<String, String> attributes = new HashMap<>();
		attributes.put("developerName", DEVELOPER_NAME);
		attributes.put("date", DATE);
		attributes.put("subject", SUBJECT);
		attributes.put("languages", LANGUAGES);
		attributes.put("location", LOCATION);

		PairingSession pairingSession = pairingSessionFactory.create(attributes);

		assertThat(pairingSession, is(aPairingSession()
	                                        .withDeveloperName(DEVELOPER_NAME)
	                                        .withDate(DATE)
	                                        .withSubject(SUBJECT)
	                                        .withLanguages(LANGUAGES)
	                                        .withLocation(LOCATION)
											.build()));
	}

}
