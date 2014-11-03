package org.findapair;

public class Application {

	public static void main(String[] args) {
		Routes routes = new Routes();
		PairProgrammingMatchmaking pairProgrammingMatchmaking = new PairProgrammingMatchmaking(routes);
		pairProgrammingMatchmaking.start();
	}

}
