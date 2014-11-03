package org.findapair;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class InvitePairTest {

	final private Pages pages = mock(Pages.class);
    final private Emailer emailer = mock(Emailer.class);
	final private Request req = mock(Request.class);
	final private Response res = mock(Response.class);

	final private InvitePair invitePair = new InvitePair( pages, emailer );

	@Test
	public void shouldSendEmailWhenInvitingPair() {
		invitePair.handle( req, res );

		verify( emailer ).sendEmail();
	}
}