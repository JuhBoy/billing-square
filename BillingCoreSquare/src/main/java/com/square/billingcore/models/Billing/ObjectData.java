package com.square.billingcore.models.Billing;

import java.util.ArrayList;
import java.util.List;

public final class ObjectData {

    public String objectBody;
    public String reference;
    public ArrayList<ObjectDetail> additionalDetails;

    public ObjectData(String object, String reference) {
        setObject(object);
        setReference(reference);
        additionalDetails = new ArrayList<>();
    }

    public String getObject() {
        return objectBody;
    }

    public void setObject(String mObject) {
        this.objectBody = mObject;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String mReference) {
        this.reference = mReference;
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
