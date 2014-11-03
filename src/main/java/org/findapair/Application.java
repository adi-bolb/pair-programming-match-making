package org.findapair;

import spark.ModelAndView;
import spark.Request;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {

	private static PersistanceLayer persistanceLayer;

	public static void main(String[] args) {
		setPersistanceLayer(new PersistanceLayer() {
			@Override
			public void save(PairingSession pairingSession) {

			}

			@Override
			public List<PairingSession> getAllPairingSessions() {
				return null;
			}
		});
		Pages pages = new Pages();
		Emailer emailer = new FakeEmailerToConsole();

		get("/", (req, res) -> pages.findAPair());
		post("/pairs", (req, res) -> pages.availablePairs());
		post("/sessions/add", (req, res) -> addNewPairingSession(req), new FreeMarkerEngine());

		formCompatiblePut("/invitations/:id", new InvitePair(pages, emailer));
		emailCompatiblePost("/invitations/:id/accept", (req, res) -> pages.invitationAccepted());
		emailCompatiblePost("/invitations/:id/reject", (req, res) -> pages.invitationRejected());
	}

	public static ModelAndView addNewPairingSession(Request req) {
		addSession(req);

		Map<String, Object> attributes = new HashMap<>();


		List<PairingSession> pairingSessions = persistanceLayer.getAllPairingSessions();

		attributes.put("pairingSessions", pairingSessions);

		return new ModelAndView(attributes, "find-a-pair.ftl");
	}

	public static void setPersistanceLayer(PersistanceLayer persistanceLayer){
		Application.persistanceLayer = persistanceLayer;
	}

	public static void addSession(Request req) {
		System.out.println("add session *****");
		// ?? validate object
		// get session object from req
		// persist session object
		PairingSession pairingSession = getPairingSessionForRequest(req);
		persistanceLayer.save(pairingSession);
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

}
