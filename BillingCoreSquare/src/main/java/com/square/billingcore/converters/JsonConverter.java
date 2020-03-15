package com.square.billingcore.converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter<T extends Object> extends Converter<T> {

    private Gson gson;

    public JsonConverter(Class<T> type) {
        super(type);
        GsonBuilder builder = new GsonBuilder();

        IJsonAdapter adapter = AdapterFactory.get(type.getName());
        Class underlyingClass = AdapterFactory.getUnderlyingClass(type.getName());
        if (adapter != null)
            builder.registerTypeAdapter(underlyingClass, adapter);

        gson = builder.create();
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
