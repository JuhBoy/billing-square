package com.square.billingcore.models.Billing;

public final class CGU {

    private String title;
    private String content;

    public CGU(String title, String content) {
        setTitle(title);
        setContent(content);
    }

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
}
