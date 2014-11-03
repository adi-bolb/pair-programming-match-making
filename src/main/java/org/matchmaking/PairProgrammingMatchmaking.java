package org.matchmaking;

public class PairProgrammingMatchmaking {

	private Routes routes;

	public PairProgrammingMatchmaking(Routes routes) {
		this.routes = routes;
	}

	public void start() {
		routes.initialise();
	}
}
