package org.findapair;

public class Session {
    private final String pairName;
    private final String time;

    public Session(String pairName, String time) {
        this.pairName = pairName;
        this.time = time;
    }

    public String getPairName() {
        return pairName;
    }

    public String getTime() {
        return time;
    }
}
