package org.findapair;

public class ThisShouldNeverHappenException extends RuntimeException {
	public ThisShouldNeverHappenException(Exception cause) {
		super(cause);
	}
}
