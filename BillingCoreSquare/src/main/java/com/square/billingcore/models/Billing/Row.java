package com.square.billingcore.models.Billing;

final class Row {

    private RowDescription mDescription;
    private int quantity;
    private int price;
    private int amount;

    private int discount;
    private ModifierType discountType;

    public Row() { }
}
