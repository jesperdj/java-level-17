package com.jesperdj.java_level_17.g_sealed;

import java.time.LocalDate;

// An example of a regular class that extends the non-sealed class PeriodParkingPermit.
public class DayParkingPermit extends PeriodParkingPermit {

    public DayParkingPermit(LocalDate date) {
        super(date.atStartOfDay(), date.atStartOfDay().plusDays(1));
    }
}
