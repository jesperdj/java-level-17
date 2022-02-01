package com.jesperdj.java_level_17.g_sealed;

import java.time.LocalDateTime;

// By making a class sealed, you can control exactly which classes may subclass it. You specify this in the 'permits' clause.
// This is useful if you are designing a class that should be extended by classes that you write yourself in the same package or module,
// but that is not designed to be extended by classes in user code.
public abstract sealed class ParkingPermit permits ResidentsParkingPermit, PeriodParkingPermit {

    public abstract boolean isValidAt(LocalDateTime dateTime);
}
