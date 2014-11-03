package org.findapair.email;

import java.util.HashMap;
import java.util.Map;

public final class FakeEmailer implements Emailer {
    private final Map<String, Inbox> inboxes = new HashMap<>();

    @Override
    public void sendEmail(Email email) {
        inboxOf(email.to).sendEmail(email);
    }

    public Inbox inboxOf(String emailAddress) {
        if (!inboxes.containsKey(emailAddress)) {
            inboxes.put(emailAddress, new Inbox());
        }
        return inboxes.get(emailAddress);
    }

    public static final class Inbox {
        private final Map<String, Email> emails = new HashMap<>();

        public void sendEmail(Email email) {
            emails.put(email.from, email);
        }

        public Email readEmailFrom(String emailAddress) {
            return emails.get(emailAddress);
        }
    }
}
