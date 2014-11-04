package org.findapair.pages;

import org.findapair.AvailableSessions;
import org.findapair.NoneSessions;
import org.findapair.Session;
import org.findapair.SomeSessions;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AvailableSessionsPageTest{

    private Session session(String name) {
        return new Session(name, "today");
    }

    @Test
    public void shouldLoadPageForRendering() throws Exception {
        PageLoader pageLoader = mock(PageLoader.class);
        when(pageLoader.loadPage(anyString())).thenReturn("%matches%");
        AvailableSessions availableSessions = new NoneSessions();
        AvailableSessionsPage availableSessionsPage = new AvailableSessionsPage( pageLoader, availableSessions);

        availableSessionsPage.render();

        verify( pageLoader ).loadPage( AvailableSessionsPage.PAGE_NAME);

    }

    @Test
    public void shouldRenderNamesOfSeveralPairsFound() {
        String name1 = "Samir";
        String name2 = "Sandro";
        String name3 = "Adi";
        AvailableSessions availableSessions = getSessions(name1, name2, name3);
        PageLoader pageLoader = mock(PageLoader.class);
        when(pageLoader.loadPage(anyString())).thenReturn("%matches%");
        Page page = new AvailableSessionsPage(pageLoader, availableSessions);

        final String renderedHtml = page.render();

        assertThat(renderedHtml, containsString(name1));
        assertThat(renderedHtml, containsString(name2));
        assertThat(renderedHtml, containsString(name3));
    }

    private AvailableSessions getSessions(String name1, String name2, String name3) {
        return  new SomeSessions(session(name1), session(name2), session(name3));
    }


}