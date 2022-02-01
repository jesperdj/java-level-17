package com.jesperdj.java_level_17.f_records_2;

import java.util.regex.Pattern;

// Domain-specific type for phone numbers (use this instead of storing a phone number in a String directly).
public record PhoneNumber(String value) {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d{10}");

    // Compact constructor
    public PhoneNumber {
        // Check if the argument is a valid phone number
        if (!PHONE_NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid phone number: " + value);
        }
    }

    // You might want to override toString() in a record like this.
    @Override
    public String toString() {
        return value;
    }
}
