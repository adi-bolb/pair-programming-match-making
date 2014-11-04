package org.findapair;

import org.findapair.pages.Page;
import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.findapair.Dummy.dummy;
import static org.mockito.Mockito.*;

public class FindPairsTest {

    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final Pairs pairsFinder = mock(Pairs.class);
    private final Pages pages = mock(Pages.class);

    @Test
    public void shouldExtractFilterCriteriaAndPassToQuery() {
        final AvailableSessions foundSessions = getSessions();
        String whatYouWantToDo = "TDD kata";
        when(request.queryParams("whatDoYouWantToDo")).thenReturn(whatYouWantToDo);
        when(pairsFinder.findFor(whatYouWantToDo)).thenReturn(foundSessions);
        when(pages.getSessionsPage(foundSessions)).thenReturn(aPage());
        FindPairs findPairs = new FindPairs(pages, pairsFinder);

        findPairs.handle(request, response);

        verify(pairsFinder).findFor(whatYouWantToDo);
    }

    @Test
    public void shouldFindPageAndRenderIt() {
        final AvailableSessions foundSessions = getSessions();
        String whatYouWantToDo = "TDD kata";
        when(request.queryParams(anyString())).thenReturn(whatYouWantToDo);
        when(pairsFinder.findFor(whatYouWantToDo)).thenReturn(foundSessions);
        Page aPage = aPage();
        when(pages.getSessionsPage(foundSessions)).thenReturn(aPage);
        FindPairs findPairs = new FindPairs(pages, pairsFinder);

        findPairs.handle(request, response);

        verify(aPage).render();
    }

    private Page aPage() {
        return mock(Page.class);
    }

    private SomeSessions getSessions() {
        return new SomeSessions(new Session("Peter", "today"));
    }

    // xyz returns the result of the template render
    // nothing found, different template
    // header? page at all? but not the html design


}
