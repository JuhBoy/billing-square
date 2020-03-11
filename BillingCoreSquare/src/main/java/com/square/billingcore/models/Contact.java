package com.square.billingcore.models;

final public class Contact {

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;

    public Contact(String lastName, String firstName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override public String toString() {
        return getLastName() + " " + getFirstName();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
