package com.jesperdj.java_level_17.d_patternmatching;

import java.time.LocalDate;

public final class Person {
    private final String name;
    private final LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        // Pre-Java 16 implementation
//        if (!(obj instanceof Person))
//            return false;
//        Person other = (Person) obj;
//        return name.equals(other.name) && birthDate.equals(other.birthDate);

        // New implementation
        return (obj instanceof Person other) && name.equals(other.name) && birthDate.equals(other.birthDate);
    }
}
