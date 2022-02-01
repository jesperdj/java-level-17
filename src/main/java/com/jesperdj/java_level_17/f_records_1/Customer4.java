package com.jesperdj.java_level_17.f_records_1;

import java.util.List;

public record Customer4(String name, List<AddressRec> addresses) {

    // You cannot add instance fields to a record.
//    private boolean isAnonymous;

    // You can add static fields.
    private static final AddressRec EMPTY_ADDRESS = new AddressRec("Null Street", "1", "Soul buoy", "Null Island");

    // You can define methods in a record, just like in a regular class.
    public AddressRec firstAddress() {
        return addresses == null || addresses.isEmpty() ? EMPTY_ADDRESS : addresses.get(0);
    }

    // You can also override the automatically generated accessor methods for fields.
    @Override
    public String name() {
        return name == null || name.isBlank() ? "Anonymous" : name;
    }
}
