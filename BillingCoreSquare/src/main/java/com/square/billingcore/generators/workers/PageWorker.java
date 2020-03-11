package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.Node;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PageWorker extends Worker<Node> {

    public PageWorker(Node model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {
        PDDocument doc = this.context.getPdfContext().getDocument();
        doc.addPage(new PDPage());
    }
}
