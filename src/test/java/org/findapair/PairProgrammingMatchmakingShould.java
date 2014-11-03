package org.findapair;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PairProgrammingMatchmakingShould {

	@Mock Routes routes;

	@Test public void
	initialise_routes() {
		new PairProgrammingMatchmaking(routes).start();

	    verify(routes).initialise();
	}
}
