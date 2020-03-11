package com.square.billingcore.models.Billing;

final public class FileInfos {

    private String fileName;

    public FileInfos(String fileName) {
        setFileName(fileName);
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
