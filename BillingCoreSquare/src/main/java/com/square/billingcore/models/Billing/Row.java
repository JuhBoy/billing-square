package com.square.billingcore.models.Billing;

public final class Row {

    private String title;
    private String content;
    private int quantity;
    private int price;
    private int amount;

    private Modifier discount;

    public Row() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Modifier getDiscount() {
        return discount;
    }

    public void setDiscount(Modifier discount) {
        this.discount = discount;
    }
}
