package com.example.billingcoresquare.models;

final public class Contact {

    private String mLastName;
    private String mFirstName;

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

    @Override public String toString() {
        return getLastName() + " " + getFirstName();
    }
}
