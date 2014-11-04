package org.matchmaking.controller;

import com.google.inject.Inject;
import org.matchmaking.view.Pages;
import spark.Request;
import spark.Response;
import spark.Route;

class FindPairingSessionsRoute implements Route {
	private Routes routes;
	private Pages pages;

	@Inject
	public FindPairingSessionsRoute(Pages pages) {
		this.pages = pages;
	}

	@Override
	public Object handle(Request req, Response res) {
		return pages.availablePairs();
	}
}
