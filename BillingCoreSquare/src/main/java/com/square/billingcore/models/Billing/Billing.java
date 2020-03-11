package com.square.billingcore.models.Billing;

import com.square.billingcore.models.Customer;

final public class Billing {

    private FileInfos fileInfos;
    private Customer customer;
    private Customer sender;
    private ImageInfos logo;
    private ObjectData object;
    private Description description;
    private CGU cgu;

    public Billing(String fileName) {
        fileInfos = new FileInfos(fileName);
    }

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

    public ImageInfos getLogo() {
        return logo;
    }

    public ObjectData getObject() {
        return object;
    }

    public Description getDescription() {
        return description;
    }

    public CGU getCgu() {
        return cgu;
    }

    public FileInfos getFileInfos() {
        return fileInfos;
    }

    /// Setters


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public void setLogo(ImageInfos logo) {
        this.logo = logo;
    }

    public void setObject(ObjectData object) {
        this.object = object;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setCgu(CGU cgu) {
        this.cgu = cgu;
    }

    public void setFileInfos(FileInfos fileInfos) {
        this.fileInfos = fileInfos;
    }
}
