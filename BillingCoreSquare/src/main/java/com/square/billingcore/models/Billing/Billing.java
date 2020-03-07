package com.square.billingcore.models.Billing;

import com.square.billingcore.models.Customer;

final public class Billing {

    private Customer mCustomer;
    private Customer mSender;
    private BillingLogo mLogo;
    private BillingObject mBillingObject;
    private BillingDesignation mDesignation;
    private BillingCgu mCgu;

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
            throw new NullPointerException("Sender can't be null");
        mSender = sender;
    }

    public void setDesignation(BillingDesignation designation) throws NullPointerException {
        if (designation == null)
            throw new NullPointerException("Designation can't be null");
        mDesignation = designation;
    }
}
