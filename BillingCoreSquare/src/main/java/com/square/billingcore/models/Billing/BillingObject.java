package com.square.billingcore.models.Billing;

import java.util.ArrayList;
import java.util.List;

final class BillingObject {

    public String mObject;
    public String mReference;
    public ArrayList<ObjectDetail> additionalDetails;

    public BillingObject(String object, String reference) {
        setObject(object);
        setReference(reference);
        additionalDetails = new ArrayList<>();
    }

    public String getObject() {
        return mObject;
    }

    public void setObject(String mObject) {
        this.mObject = mObject;
    }

    public String getReference() {
        return mReference;
    }

    public void setReference(String mReference) {
        this.mReference = mReference;
    }

    /**
     * Return a shallow copy of the intern list of  additional details
     * @return Additional Details.
     */
    public List<ObjectDetail> getDetails() {
        return new ArrayList<>(additionalDetails);
    }

    /**
     * Add a new detail
     * @param detail Detail can not be null.
     * @throws NullPointerException if Detail object is null
     */
    public void addDetail(ObjectDetail detail) throws NullPointerException {
        if (detail == null)
            throw new NullPointerException("Object must not be null");
        additionalDetails.add(detail);
    }

    public void removeDetail(ObjectDetail detail) {
        additionalDetails.remove(detail);
    }
}
