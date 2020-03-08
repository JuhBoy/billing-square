package com.square.billingcore.converters;

import com.google.gson.Gson;

class JsonConverter<T extends Object> extends Converter<T> {

    private Gson gson;

    public JsonConverter(Class<T> type) {
        super(type);
        gson = new Gson();
    }

    @Override
    public String serialize(T model) throws NullPointerException {
        if (model == null)
            throw new NullPointerException("model can't be null");
        return gson.toJson(model);
    }

    @Override
    public T deserialize(String content) {
        T model = gson.fromJson(content, this.type);
        return model;
    }
}
