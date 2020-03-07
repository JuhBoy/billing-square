package com.example.billingcoresquare.models.Billing;

import com.example.billingcoresquare.models.Customer;

final public class Billing {

    private Customer mCustomer;
    private Customer mSender;

    private Billing() { }

    public Billing(Customer customer, Customer sender) {
        setCustomer(customer);
        setSender(sender);
    }

    public void setCustomer(Customer customer) throws NullPointerException {
        if (customer == null)
            throw new NullPointerException("Customer can't be null");
        mCustomer = customer;
    }

    public void setSender(Customer sender) throws NullPointerException {
        if (sender == null)
            throw new NullPointerException("Customer can't be null");
        mSender = sender;
    }
}
