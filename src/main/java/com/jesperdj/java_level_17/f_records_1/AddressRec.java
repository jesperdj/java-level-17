package com.jesperdj.java_level_17.f_records_1;

// By writing it as a record, you can define an immutable data object with just a few lines.
public record AddressRec(String street, String houseNumber, String city, String country) {
}
