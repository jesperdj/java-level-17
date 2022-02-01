package com.jesperdj.java_level_17.f_records_2;

import java.util.regex.Pattern;

// Domain-specific type for email addresses (use this instead of storing an email address in a String directly).
public record EmailAddress(String value) {

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(".+@.+\\..+");

    // Compact constructor
    public EmailAddress {
        // Check if the argument is a valid email address
        if (!EMAIL_ADDRESS_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email address: " + value);
        }
    }

    // You might want to override toString() in a record like this.
    @Override
    public String toString() {
        return value;
    }
}
