package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.Node;
import com.square.billingcore.generators.models.TextNode;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class TextWorker extends Worker<Node> {

    public TextWorker(Node model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {

    }

    private void flushString(String[] data) {
        PDDocument document = context.getPdfContext().getDocument();
        PDPage lastPage = document.getPage(document.getPages().getCount() - 1);
        TextNode lModel = (TextNode) model;

        /*
        try {
            PDPageContentStream stream = new PDPageContentStream(document, lastPage);
            stream.setLeading(lModel.getTextLeading());

            stream.beginText();

            stream.setFont(PDType1Font.HELVETICA, lModel.getFontSizes()[0]);
            stream.newLineAtOffset((float)lModel.getPosition().getX(), (float)lModel.getPosition().getY());

            for (String text : data) {
                stream.showText(text);
                stream.newLine();
            }

            stream.endText();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         */
    }
}
