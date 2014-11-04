package org.matchmaking.domain;

import java.util.Map;

public class PairingSessionFactory {
	public PairingSession create(Map<String, String> paramsMap) {
		return new PairingSession(
						paramsMap.get("developerName"),
						paramsMap.getOrDefault("date", "Any date"),
						paramsMap.getOrDefault("subject", ""),
						paramsMap.getOrDefault("languages", ""),
						paramsMap.getOrDefault("location", ""));
	}
}
