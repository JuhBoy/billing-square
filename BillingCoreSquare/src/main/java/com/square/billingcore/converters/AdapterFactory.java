package com.square.billingcore.converters;

import com.square.billingcore.generators.models.Node;

public class AdapterFactory {

    private final static String NODE_ADAPTER = "com.square.billingcore.generators.models.Node";
    private final static String LAYOUT_ADAPTER = "com.square.billingcore.generators.PDFDataLayout";

    public static IJsonAdapter get(String type) {
        switch (type) {
            case LAYOUT_ADAPTER:
            case NODE_ADAPTER:
                return new NodeSerializer();
            default:
                return null;
        }
    }

    public static Class getUnderlyingClass(String name) {
        switch (name) {
            case LAYOUT_ADAPTER:
            case NODE_ADAPTER:
                return Node.class;
            default:
                return null;
        }
    }
}
