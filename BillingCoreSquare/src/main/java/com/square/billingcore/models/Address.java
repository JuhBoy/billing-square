package com.square.billingcore.models;

final public class Address {

    private String mStreet;
    private String mCity;
    private String mPostalCode;
    private String mCountry;

    public Address(String street, String city, String postalCode, String country) {
        setStreet(street);
        setCountry(country);
        setCity(city);
        setPostalCode(postalCode);
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
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
