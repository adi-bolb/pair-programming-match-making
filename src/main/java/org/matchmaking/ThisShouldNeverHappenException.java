package org.matchmaking;

public class ThisShouldNeverHappenException extends RuntimeException {
	public ThisShouldNeverHappenException(Exception cause) {
		super(cause);
	}
}
