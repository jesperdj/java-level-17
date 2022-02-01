package com.jesperdj.java_level_17.g_sealed;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <a href="https://openjdk.java.net/jeps/409">JEP 409</a>: Sealed Classes.
 * <p>
 * A way to control subclassing and implementation of interfaces, standard since JDK 17.
 */
public class SealedClasses {

    public static void main(String[] args) {
        ParkingPermit permit1 = new ResidentsParkingPermit(UUID.randomUUID());
        System.out.println(permit1.isValidAt(LocalDateTime.now()));

        ParkingPermit permit2 = new PeriodParkingPermit(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        System.out.println(permit2.isValidAt(LocalDateTime.now()));
    }
}
