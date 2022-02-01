package com.jesperdj.java_level_17.g_sealed;

import java.time.LocalDateTime;
import java.util.UUID;

// Subclasses of a sealed class must be either final, sealed or non-sealed.
public final class ResidentsParkingPermit extends ParkingPermit {

    private final UUID residentId;

    public ResidentsParkingPermit(UUID residentId) {
        this.residentId = residentId;
    }

    public UUID getResidentId() {
        return residentId;
    }

    @Override
    public boolean isValidAt(LocalDateTime dateTime) {
        return true;
    }
}
