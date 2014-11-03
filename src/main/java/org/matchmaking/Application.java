package org.matchmaking;

import org.matchmaking.controller.Routes;

public class Application {

	public static void main(String[] args) {
		Routes routes = new Routes();
		PairProgrammingMatchmaking pairProgrammingMatchmaking = new PairProgrammingMatchmaking(routes);
		pairProgrammingMatchmaking.start();
	}

}
