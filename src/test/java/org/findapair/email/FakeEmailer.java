package org.findapair.email;

public final class FakeEmailer implements Emailer {
    @Override
    public void sendEmail(Email email) {
        throw new UnsupportedOperationException();
    }

    public Inbox inboxOf(String emailAddress) {
        throw new UnsupportedOperationException();
    }
}
