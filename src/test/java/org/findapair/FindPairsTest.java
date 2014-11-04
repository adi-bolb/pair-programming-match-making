package org.findapair;

import org.findapair.pages.AvailableSessionsPage;
import org.findapair.pages.PageLoader;
import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.findapair.Dummy.dummy;
import static org.mockito.Mockito.*;

public class FindPairsTest {

    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final Pairs backend = mock(Pairs.class);
    private final Pages pages = mock(Pages.class);

    @Test
    public void shouldExtractFilterCriteriaAndPassToQuery() {
        final AvailableSessions foundSessions = getSessions();
        String whatYouWantToDo = "TDD kata";
        when(request.params("whatDoYouWantToDo")).thenReturn(whatYouWantToDo);
        when(backend.findFor(whatYouWantToDo)).thenReturn(foundSessions);
        when(pages.getSessionsPage(any())).thenReturn(new AvailableSessionsPage(new PageLoader(), foundSessions));
        FindPairs findPairs = new FindPairs(pages, backend);

        findPairs.handle(request, response);

        verify(pages).getSessionsPage(foundSessions);
    }

    private SomeSessions getSessions() {
        return new SomeSessions(new Session("Peter", "today"));
    }

    // xyz returns the result of the template render
    // nothing found, different template
    // header? page at all? but not the html design


}
