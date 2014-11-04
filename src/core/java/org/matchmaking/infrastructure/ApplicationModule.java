package org.matchmaking.infrastructure;

import com.google.inject.AbstractModule;
import org.matchmaking.domain.PairingSessions;
import org.matchmaking.infrastructure.repositories.PairingSessionsInMemory;

import static com.google.inject.Scopes.SINGLETON;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PairingSessions.class).to(PairingSessionsInMemory.class).in(SINGLETON);
	}
}
