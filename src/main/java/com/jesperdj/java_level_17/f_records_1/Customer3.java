package com.jesperdj.java_level_17.f_records_1;

import java.util.List;

public record Customer3(String name, List<AddressRec> addresses) {

    // Records are only shallowly immutable. A record may contain fields of mutable types. You might want to make defensive copies of mutable objects
    // to ensure immutability.
    public Customer3 {
        // Make an unmodifiable copy of the argument 'addresses'
        addresses = List.copyOf(addresses);
    }
}
