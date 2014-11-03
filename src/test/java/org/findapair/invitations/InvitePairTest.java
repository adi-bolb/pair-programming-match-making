package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;
import org.junit.Test;

import static org.findapair.testing.Dummy.dummy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvitePairTest {
	private final Pages pages = dummy(Pages.class);

	private final Emailer emailer = mock(Emailer.class);
	private final InvitePair invitePair = new InvitePair( pages, emailer );

	@Test
	public void shouldSendTheCorrectEmailWhenInvitingPair() {
		invitePair.go();

		verify(emailer).sendEmail(Emails.InvitationEmail.make());
	}

}
