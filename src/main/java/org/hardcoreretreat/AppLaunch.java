package org.hardcoreretreat;

import static spark.Spark.get;

public class AppLaunch {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}
}
