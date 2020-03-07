package com.example.billingcoresquare.models.Billing;

final class RowDescription {

    private String title;
    private String body;

    private RowDescription(String title, String body) {
        setTitle(title);
        setBody(body);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
