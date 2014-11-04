package org.matchmaking;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.matchmaking.controller.Routes;
import org.matchmaking.infrastructure.ApplicationModule;

public class Application {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ApplicationModule());
		Routes routes = injector.getInstance(Routes.class);

		PairProgrammingMatchmaking pairProgrammingMatchmaking = new PairProgrammingMatchmaking(routes);
		pairProgrammingMatchmaking.start();
	}

}
