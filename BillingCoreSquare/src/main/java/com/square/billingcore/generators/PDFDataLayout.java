package com.square.billingcore.generators;

import com.square.billingcore.generators.models.Node;

public final class PDFDataLayout {
    private Node head;
    private String fileName;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}



