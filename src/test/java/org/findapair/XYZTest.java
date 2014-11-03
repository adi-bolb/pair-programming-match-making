package org.findapair;

import org.junit.Test;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.List;

import static org.findapair.Dummy.dummy;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class XYZTest  {

    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);

    private final XyzBackend backend = mock(XyzBackend.class);
    private final Pages pages = mock(Pages.class);

    @Test
    public void shouldExtractFilterCriteriaAndPassToQuery() {
        String whatYouWantToDo = "TDD kata";
        when(request.params("whatDoYouWantToDo")).thenReturn(whatYouWantToDo);
        XYZ xyz = new XYZ(pages, backend);

        xyz.handle(request, response);

        verify(backend).findPairs(whatYouWantToDo);
    }

    @Test
    public void shouldPassFoundPairsToRendering() {
        final List<Pair> foundPairs = Arrays.asList(new Pair("Peter"));
        when(backend.findPairs(anyString())).thenReturn(foundPairs);
        XYZ xyz = new XYZ(pages, backend);

        xyz.handle(request, response);

        verify(pages).availablePairs( foundPairs );
    }

    // xyz returns the result of the template render
    // nothing found
    // header? page at all? but not the html design


}
