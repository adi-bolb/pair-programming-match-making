package org.findapair;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class FindPairs implements Route {
    private final Pages template;
    private final Pairs sessions;

    public FindPairs(Pages template, Pairs sessions) {
        this.template = template;
        this.sessions = sessions;
    }

    @Override
    public Object handle(Request req, Response res) {
        final String whatDoYouWantToDo = req.params("whatDoYouWantToDo");

        final List<Session> availableSessions = sessions.findFor(whatDoYouWantToDo);

        return template.renderAsAvailable(availableSessions);
    }
}
