package org.findapair.pairing;

public final class Saved<T> {
    private final Id id;
    private final T value;

    public Saved(Id id, T value) {
        this.id = id;
        this.value = value;
    }

    public Id id() {
        return id;
    }

    public T value() {
        return value;
    }
}
