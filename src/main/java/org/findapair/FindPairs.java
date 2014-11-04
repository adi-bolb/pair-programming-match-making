package org.findapair;

import org.findapair.pages.Page;
import spark.Request;
import spark.Response;
import spark.Route;

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

        final AvailableSessions availableSessions = sessions.findFor(whatDoYouWantToDo);

        return getAvailableSessionsPage(availableSessions).renderAsAvailable();
    }

    private Page getAvailableSessionsPage(AvailableSessions availableSessions) {
        return template.getAvailableSessionsPage(availableSessions);
    }
}
