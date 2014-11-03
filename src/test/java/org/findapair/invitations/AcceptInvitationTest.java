package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;
import org.junit.Test;

import static org.findapair.testing.Dummy.dummy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AcceptInvitationTest {
    private final Pages pages = dummy(Pages.class);

    private final Emailer emailer = mock(Emailer.class);
    private final AcceptInvitation acceptInvitation = new AcceptInvitation(pages, emailer);

    @Test
    public void emailsTheInviterWhenAcceptingAnInvitation() {
        acceptInvitation.go();

        verify(emailer).sendEmail(Emails.AcceptanceEmail.make());
    }
}
