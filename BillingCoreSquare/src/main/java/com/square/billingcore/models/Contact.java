package com.square.billingcore.models;

final public class Contact {

    private String mLastName;
    private String mFirstName;
    private String phoneNumber;

    public Contact(String lastName, String firstName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
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
}
