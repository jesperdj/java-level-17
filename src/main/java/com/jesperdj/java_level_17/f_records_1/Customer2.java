package com.jesperdj.java_level_17.f_records_1;

import java.util.List;

public record Customer2(String name, List<AddressRec> addresses) {

    // You can also define the canonical constructor yourself, using the regular syntax for constructors. If you do this, you do need to initialize the fields
    // of the record yourself.
    public Customer2(String name, List<AddressRec> addresses) {
        if (name == null || name.isBlank()) {
            name = "Anonymous";
        }

        if (addresses == null || addresses.isEmpty()) {
            throw new IllegalArgumentException("Customer addresses must not be null or empty");
        }

        this.name = name;
        this.addresses = addresses;
    }

    // You can define additional constructors as well, which need to have a different argument list than the canonical constructor.
    // Any additional constructors must call another constructor using 'this(...)', so that ultimately the canonical constructor is always called.
    public Customer2(String name, AddressRec address) {
        this(name, List.of(address));
    }
}
