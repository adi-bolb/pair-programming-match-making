package org.findapair;

public final class Emails {
    public static final class AcceptanceEmail {
        public static Email make() {
            return new Email(
                    "something@findapair.org",
                    "alex@boly.com",
                    "Invitation Accepted",
                    "Sandro Mancuso has accepted your invitation to pair. You can contact them at sandro@mancuso.com."
            );
        }
    }

    public static class InvitationEmail {
        public static Email make() {
            String from = "samir@samir.com";
            String to = "peter@peter.com";
            String subject = "Invitation Subject";
            String body =
                    "Accept: http://localhost:4567/invitations/1/accept\n"
                  + "Reject: http://localhost:4567/invitations/1/reject\n";
            return new Email(from, to, subject, body);
        }
    }
}
