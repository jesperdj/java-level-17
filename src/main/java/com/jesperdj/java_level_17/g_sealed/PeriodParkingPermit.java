package com.jesperdj.java_level_17.g_sealed;

import java.time.LocalDateTime;

// When you make a subclass of a sealed class non-sealed, then you are opening up the class hierarchy again from this point on.
// You would use this to indicate that a specific subclass is designed to be extended.
public non-sealed class PeriodParkingPermit extends ParkingPermit {

    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    public PeriodParkingPermit(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @Override
    public boolean isValidAt(LocalDateTime dateTime) {
        return !dateTime.isBefore(startDateTime) && dateTime.isBefore(endDateTime);
    }
}
