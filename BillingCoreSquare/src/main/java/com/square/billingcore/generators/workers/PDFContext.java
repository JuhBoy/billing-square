package com.square.billingcore.generators.workers;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFContext {

    private PDDocument document;

    public PDDocument getDocument() {
        return document;
    }

    public PDFContext setDocument(PDDocument document) {
        this.document = document;
        return this;
    }
}