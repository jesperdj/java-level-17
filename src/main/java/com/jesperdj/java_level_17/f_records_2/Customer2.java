package com.jesperdj.java_level_17.f_records_2;

// To improve this, you can create domain-specific types: EmailAddress and PhoneNumber.
// Then you can implement the validation for those specific types there, and it can easily be reused.
// Records make creating domain-specific types easy and worthwhile because it only takes a few lines to define a record.
public record Customer2(String name, EmailAddress emailAddress, PhoneNumber phoneNumber) {
}
