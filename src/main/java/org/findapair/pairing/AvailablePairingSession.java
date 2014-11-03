package org.findapair.pairing;

public final class AvailablePairingSession {
    private final String programmerName;
    private final String description;

    public AvailablePairingSession(String programmerName, String description) {
        this.programmerName = programmerName;
        this.description = description;
    }

    public String programmerName() {
        return programmerName;
    }

    public String description() {
        return description;
    }
}
