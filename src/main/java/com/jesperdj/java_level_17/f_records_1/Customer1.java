package com.jesperdj.java_level_17.f_records_1;

import java.util.List;

public record Customer1(String name, List<AddressRec> addresses) {

    // You might want to override the canonical constructor, for example to check if the arguments are valid before initializing the fields.
    // One way to override the canonical constructor is by providing a compact constructor. Note:
    // - There is no argument list after the name of the compact constructor
    // - The compact constructor does not need to assign to the fields of the record; this happens automatically after executing the compact constructor
    // - The compact constructor may assign new values to the arguments (in this example: a default name "Anonymous")
    public Customer1 {
        if (name == null || name.isBlank()) {
            name = "Anonymous";
        }

        if (addresses == null || addresses.isEmpty()) {
            throw new IllegalArgumentException("Customer addresses must not be null or empty");
        }
    }
}
