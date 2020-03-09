package com.square.billingcore.management;

import com.square.billingcore.models.Billing.Billing;

public interface IBillingManager {

    Billing create(String fileName) throws Exception;
    Billing load(String fileName) throws Exception;
    String[] getAvailable() throws Exception;
    void update(Billing billing) throws Exception;
    boolean remove(Billing billing) throws Exception;
    boolean exists(String identifier) throws Exception;

}
