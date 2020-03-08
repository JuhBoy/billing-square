package com.square.billingcore.models.Billing;

import com.square.billingcore.models.Customer;

final public class Billing {

    private Customer customer;
    private Customer sender;
    private BillingLogo logo;
    private BillingObject billingObject;
    private BillingDesignation designation;
    private BillingCgu cgu;

    private Billing() { }

    public Billing(Customer customer, Customer sender) {
        setCustomer(customer);
        setSender(sender);
    }

    /// Getters

    public Customer getCustomer() {
        return customer;
    }

    public Customer getSender() {
        return sender;
    }

    public BillingLogo getLogo() {
        return logo;
    }

    public BillingObject getBillingObject() {
        return billingObject;
    }

    public BillingDesignation getDesignation() {
        return designation;
    }

    public BillingCgu getCgu() {
        return cgu;
    }

    /// Setters


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public void setLogo(BillingLogo logo) {
        this.logo = logo;
    }

    public void setBillingObject(BillingObject billingObject) {
        this.billingObject = billingObject;
    }

    public void setDesignation(BillingDesignation designation) {
        this.designation = designation;
    }

    public void setCgu(BillingCgu cgu) {
        this.cgu = cgu;
    }
}
