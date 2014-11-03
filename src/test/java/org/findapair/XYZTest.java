package org.findapair;

import org.hamcrest.core.StringContains;
import org.junit.Ignore;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.util.Arrays;

import static org.findapair.Dummy.dummy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class XYZTest  {

    private final Pages pages = dummy(Pages.class);
    private final Request request = dummy(Request.class);
    private final Response response = dummy(Response.class);
    private XyzBackend backend = mock(XyzBackend.class);

    @Test
    public void shouldExtractFilterCriteriaAndPassToQuery() {
        String whatYouWantToDo = "TDD kata";
        when(request.params("whatDoYouWantToDo")).thenReturn(whatYouWantToDo);
        XYZ xyz = new XYZ(pages, backend);

        xyz.handle(request, response);

        verify(backend).findPairs(whatYouWantToDo);
    }

    @Ignore
    @Test
    public void shouldRendereFoundPairs() {
        when(backend.findPairs(anyString())).thenReturn(Arrays.asList("Peter")); // TODO primitive?
        XYZ xyz = new XYZ(pages);

        String renderedPage = xyz.handle(request, response).toString();

        assertThat(renderedPage, new StringContains("Peter"));
    }


}
