package com.jesperdj.java_level_17.f_records_1;

import java.util.Objects;

// Writing an immutable data transfer object in Java can quickly take up 50+ lines of code. A lot of boilerplate code is necessary:
// - Add private final member variables
// - Add a constructor that copies arguments to each of the member variables
// - Add a getter method for each member variable
// - Make the class final
// - Implement equals(), hashCode() and toString() methods
public final class Address {
    private final String street;
    private final String houseNumber;
    private final String city;
    private final String country;

    public Address(String street, String houseNumber, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, city, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
