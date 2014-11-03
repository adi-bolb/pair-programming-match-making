package org.findapair.pages;

public class ThisShouldNeverHappenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThisShouldNeverHappenException(String message) {
        super(message);
    }

	public ThisShouldNeverHappenException(Exception cause) {
		super(cause);
	}
}
