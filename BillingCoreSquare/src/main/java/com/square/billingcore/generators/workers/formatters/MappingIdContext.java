package com.square.billingcore.generators.workers.formatters;

import com.square.billingcore.models.Billing.Billing;

import java.util.HashMap;

public abstract class MappingIdContext<T extends Object> extends HashMap<Integer, Object> {

    protected T model;

    public MappingIdContext(T model) {
        this.model = model;
    }
}
