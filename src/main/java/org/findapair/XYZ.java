package org.findapair;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

class XYZ implements Route {
    private final Pages pages;
    private final XyzBackend backend;

    public XYZ(Pages pages) {
        this.pages = pages;
        backend = null; //FIXME AkS: fix
    }

    public XYZ(Pages pages, XyzBackend backend) {
        this.pages = pages;
        this.backend = backend;
    }

    @Override
    public Object handle(Request req, Response res) {
        final String whatDoYouWantToDo = req.params("whatDoYouWantToDo");

        final List<String> pairs = backend.findPairs(whatDoYouWantToDo);

        return pages.availablePairs();
    }
}
