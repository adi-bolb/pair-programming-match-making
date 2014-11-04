package org.matchmaking.controller;

import org.matchmaking.domain.PairingSession;
import spark.Request;

import java.util.Map;

public class PairingSessionFactory {
	public PairingSession create(Request paramsMap) {
		return new PairingSession(
						paramsMap.queryParams("developerName"),
						paramsMap.queryParams("date"),
						paramsMap.queryParams("subject"),
						paramsMap.queryParams("languages"),
						paramsMap.queryParams("location"));
	}

	public PairingSession create(Map<String, String> attributes) {
		return new PairingSession(
									attributes.get("developerName"),
									attributes.getOrDefault("date", ""),
									attributes.getOrDefault("subject", ""),
									attributes.getOrDefault("languages", ""),
									attributes.getOrDefault("location", ""));
	}
}
