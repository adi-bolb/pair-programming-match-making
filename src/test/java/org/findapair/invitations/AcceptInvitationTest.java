package org.findapair.invitations;

import org.findapair.email.Emailer;
import org.findapair.email.Emails;
import org.findapair.pages.Pages;
import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.findapair.testing.Dummy.dummy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AcceptInvitationTest {
    private final Pages pages = dummy(Pages.class);
    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final Emailer emailer = mock(Emailer.class);
    private final AcceptInvitation acceptInvitation = new AcceptInvitation(pages, emailer);

    @Test
    public void emailsTheInviterWhenAcceptingAnInvitation() {
        acceptInvitation.handle(request, response);

        verify(emailer).sendEmail(Emails.AcceptanceEmail.make());
    }
}
