package org.matchmaking.view;

public class ThisShouldNeverHappenException extends RuntimeException {
	public ThisShouldNeverHappenException(Exception cause) {
		super(cause);
	}
}
