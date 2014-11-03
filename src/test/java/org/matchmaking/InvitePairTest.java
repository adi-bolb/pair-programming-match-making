package org.matchmaking;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.matchmaking.Dummy.dummy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvitePairTest {

	private final Pages pages = dummy(Pages.class);
	private final Request req = dummy(Request.class);
	private final Response res = dummy(Response.class);

	private final Emailer emailer = mock(Emailer.class);
	private final InvitePair invitePair = new InvitePair( pages, emailer );

	@Test
	public void shouldSendTheCorrectEmailWhenInvitingPair() {
		invitePair.handle(req, res);

		verify(emailer).sendEmail(InvitationEmail.make());
	}

}
