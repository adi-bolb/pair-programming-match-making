package org.findapair;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.findapair.Dummy.dummy;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindPairsTest {

    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final Pairs backend = mock(Pairs.class);
    private final Pages pages = mock(Pages.class);

    @Test
    public void shouldExtractFilterCriteriaAndPassToQuery() {
        String whatYouWantToDo = "TDD kata";
        when(request.params("whatDoYouWantToDo")).thenReturn(whatYouWantToDo);
        FindPairs xyz = new FindPairs(pages, backend);

        xyz.handle(request, response);

        verify(backend).findFor(whatYouWantToDo);
    }

    @Test
    public void shouldPassFoundPairsToRendering() {
        final AvailableSessions foundSessions = getSessions();
        when(backend.findFor(anyString())).thenReturn(foundSessions);
        FindPairs xyz = new FindPairs(pages, backend);

        xyz.handle(request, response);

        verify(pages).renderAsAvailable(foundSessions);
    }

    private SomeSessions getSessions() {
        return  new SomeSessions(new Session("Peter", "today"));
    }

    @Test
    public void shouldRenderDifferentPageWhenNoSessionsFound() {
        final AvailableSessions noSessions = new NoneSessions();
        when(backend.findFor(anyString())).thenReturn(noSessions);
        FindPairs xyz = new FindPairs(pages, backend);

        xyz.handle(request, response);

        verify(pages).renderNoSessionsAvailable();
    }

    // xyz returns the result of the template render
    // header? page at all? but not the html design


}
