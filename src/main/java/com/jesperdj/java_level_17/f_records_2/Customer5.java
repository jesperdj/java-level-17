package com.jesperdj.java_level_17.f_records_2;

// Take a look at this "stringly typed" record (that's a pun on "strongly typed").
// You could put anything in the 'emailAddress' and 'phoneNumber' fields. You could add a constructor with validation,
// but still the type String of these fields doesn't have any meaning in the business domain.
public record Customer5(String name, String emailAddress, String phoneNumber) {
}
