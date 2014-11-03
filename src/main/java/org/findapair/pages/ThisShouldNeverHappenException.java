package org.findapair.pages;

public class ThisShouldNeverHappenException extends RuntimeException {
	public ThisShouldNeverHappenException(Exception cause) {
		super(cause);
	}
}
