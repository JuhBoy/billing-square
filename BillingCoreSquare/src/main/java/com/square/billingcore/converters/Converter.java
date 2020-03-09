package com.square.billingcore.converters;

import com.square.billingcore.utils.ObjectUtils;

public abstract class Converter<T extends Object> {

    protected Class<T> type;

    public Converter(Class<T> type) {
        this.type = type;
    }

    public abstract String serialize(T model);
    public abstract T deserialize(String content);

    public Class<T> getInnerType() {
        return this.type;
    }
}
