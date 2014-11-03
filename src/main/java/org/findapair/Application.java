package org.findapair;

import spark.Request;
import spark.Route;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	public static void main(String[] args) {
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();

		get("/", (req, res) -> pages.findAPair());
		post("/pairs", (req, res) -> pages.availablePairs());
		post("/sessions/add", (req, res) -> addSession());

		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	public static Object addSession() {
		// get session object from req
		// ?? validate object
		// persist session object
		// return to initial page
		// show the list of sessions
		return null;
	}

	public static PairingSession getPairingSessionForRequest(Request req){

		String name = req.params("name");
		String date = req.params("date");
		String subject = req.params("subject");
		String languages = req.params("languages");
		String location = req.params("location");
		return new PairingSession(name, date, subject, languages, location);
	}

	private static void formCompatiblePut(String path, Route route) {
		post(path, route);
	}

	private static void emailCompatiblePost(String path, Route route) {
		get(path, route);
	}

	public static class PairingSession {
		private final String name;
		private final String date;
		private final String subject;
		private final String languages;
		private final String location;

		public PairingSession(String name, String date, String subject, String languages, String location) {
			this.name = name;
			this.date = date;
			this.subject = subject;
			this.languages = languages;
			this.location = location;
		}

		public String name() {
			return name;
		}

		public String date() {
			return date;
		}

		public String subject() {
			return subject;
		}

		public String languages() {
			return languages;
		}

		public String location() {
			return location;
		}

		@Override
		public boolean equals(Object o) {
			return reflectionEquals(this, o);
		}

		@Override
		public int hashCode() {
			return reflectionHashCode(this);
		}

	}
}
