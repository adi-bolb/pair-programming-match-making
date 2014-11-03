package org.findapair;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.findapair.Dummy.dummy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RejectInvitationTest {

    private final Pages pages = dummy(Pages.class);
    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final Emailer emailer = mock(Emailer.class);
    private final RejectInvitation rejectInvitation = new RejectInvitation(pages, emailer);

    @Test
    public void emailsTheInviterWhenRejectAnInvitation() {
        rejectInvitation.handle(request, response);

        verify(emailer).sendEmail(Emails.RejectionEmail.make());
    }
}
