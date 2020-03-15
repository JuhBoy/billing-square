package com.square.billingcore.converters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.square.billingcore.generators.models.Node;

import java.lang.reflect.Type;

public class NodeSerializer implements JsonSerializer<Node>, JsonDeserializer<Node>, IJsonAdapter {

    private static final String CLASS_TYPE = "ClassType";
    private static final String INSTANCE = "Instance";

    @Override
    public Node deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject obj = json.getAsJsonObject();
        JsonPrimitive element = (JsonPrimitive) obj.get(CLASS_TYPE);

        Class<?> klass;
        try {
            klass = Class.forName(element.getAsString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new JsonParseException(ex.getMessage());
        }

        return context.deserialize(obj.get(INSTANCE), klass);
    }

    @Override
    public JsonElement serialize(Node src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        String className = src.getClass().getName();
        jsonObject.addProperty(CLASS_TYPE, className);
        JsonElement element = context.serialize(src);
        jsonObject.add(INSTANCE, element);

        return jsonObject;
    }
}
