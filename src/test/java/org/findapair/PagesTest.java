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
            List<Pair> singlePairFound = Arrays.asList(pair(name));

            final String renderedHtml = pages.renderAsAvailable(singlePairFound);

            assertThat(renderedHtml, containsString(name));
        }

        private Pair pair(String name) {
            return new Pair(name);
        }

        @Test
        public void shouldRenderNamesOfSeveralPairsFound() {
            Pages pages = new Pages();
            String name1 = "Samir";
            String name2 = "Sandro";
            String name3 = "Adi";
            List<Pair> singlePairFound = Arrays.asList(pair(name1), pair(name2), pair(name3));

            final String renderedHtml = pages.renderAsAvailable(singlePairFound);

            assertThat(renderedHtml, containsString(name1));
            assertThat(renderedHtml, containsString(name2));
            assertThat(renderedHtml, containsString(name3));
        }

    }
}
