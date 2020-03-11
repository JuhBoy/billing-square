package com.square.billingcore.models;

final public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Address(String street, String city, String postalCode, String country) {
        setStreet(street);
        setCountry(country);
        setCity(city);
        setPostalCode(postalCode);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Address: " + '\n');
        builder.append(getStreet() + "\n");
        builder.append(getPostalCode() + " " + getCity() + "\n");
        builder.append(getCountry());

        return builder.toString();
    }
}
