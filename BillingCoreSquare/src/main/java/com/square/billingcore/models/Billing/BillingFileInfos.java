package com.square.billingcore.models.Billing;

final public class BillingFileInfos {

    private String fileName;

    public BillingFileInfos(String fileName) {
        setFileName(fileName);
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
