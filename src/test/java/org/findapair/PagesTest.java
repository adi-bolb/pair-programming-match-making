package org.findapair;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(Enclosed.class)
public class PagesTest {

    public static class WithAvailablePairs{

        @Test
        public void shouldRenderTheNameTheSinglePairFound() {
            Pages pages = new Pages();
            String name = "ANY NAME";
            AvailableSessions singleSessionFound = getSessions(name);

            final String renderedHtml = pages.renderAsAvailable(singleSessionFound);

            assertThat(renderedHtml, containsString(name));
        }

        private AvailableSessions getSessions(String name) {
            return new SomeSessions( session(name) ) ;
        }

        private Session session(String name) {
            return new Session(name, "today");
        }

        @Test
        public void shouldRenderNamesOfSeveralPairsFound() {
            Pages pages = new Pages();
            String name1 = "Samir";
            String name2 = "Sandro";
            String name3 = "Adi";
            AvailableSessions singleSessionFound = getSessions(name1, name2, name3);

            final String renderedHtml = pages.renderAsAvailable(singleSessionFound);

            assertThat(renderedHtml, containsString(name1));
            assertThat(renderedHtml, containsString(name2));
            assertThat(renderedHtml, containsString(name3));
        }

        private AvailableSessions getSessions(String name1, String name2, String name3) {
            return  new SomeSessions(session(name1), session(name2), session(name3));
        }

    }
}
