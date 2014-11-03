package org.findapair.pairing;

public final class Id {
    private final int value;

    public Id(int value) {
        this.value = value;
    }

    public static Id from(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Id)) return false;

        Id that = (Id) other;
        return this.value == that.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
