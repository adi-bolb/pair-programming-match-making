package org.findapair.database;

import java.util.Collection;
import org.findapair.pairing.AvailablePairingSession;
import org.findapair.pairing.Saved;

public interface Database {
    void add(AvailablePairingSession session);

    Collection<Saved<AvailablePairingSession>> list();
}
