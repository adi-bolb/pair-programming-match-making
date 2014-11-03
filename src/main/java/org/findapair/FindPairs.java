package org.findapair;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class FindPairs implements Route {
    private final Pages template;
    private final Pairs backend;

    public FindPairs(Pages template, Pairs backend) {
        this.template = template;
        this.backend = backend;
    }

    @Override
    public Object handle(Request req, Response res) {
        final String whatDoYouWantToDo = req.params("whatDoYouWantToDo");

        final List<Pair> pairs = backend.findPairs(whatDoYouWantToDo);

        return template.renderAsAvailable(pairs);
    }
}
