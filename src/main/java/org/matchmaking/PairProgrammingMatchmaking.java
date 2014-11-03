package org.matchmaking;

import org.matchmaking.controller.Routes;

public class PairProgrammingMatchmaking {

	private Routes routes;

	public PairProgrammingMatchmaking(Routes routes) {
		this.routes = routes;
	}

	public void start() {
		routes.initialise();
	}
}
