package com.square.billingcore.generators;
import com.square.billingcore.generators.models.Node;
import com.square.billingcore.generators.workers.IWorker;
import com.square.billingcore.generators.workers.PDFContext;
import com.square.billingcore.generators.workers.WorkerContext;
import com.square.billingcore.generators.workers.WorkerFactory;
import com.square.billingcore.generators.workers.formatters.MappingIdContext;
import com.square.billingcore.logging.ILogger;
import com.square.billingcore.models.Billing.Billing;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFGenerator extends Generator<Billing, Byte[]> {

    private final ILogger logger;
    private PDFDataLayout layout;
    private WorkerContext context;

    public PDFGenerator(PDFDataLayout layout, MappingIdContext mappingContext, ILogger logger) {
        super();

        this.logger = logger;
        this.layout = layout;
        this.context = new WorkerContext();
        context.setMappingContext(mappingContext);
        context.setPdfContext(new PDFContext());
        context.setFactory(new WorkerFactory(context));
    }

    @Override
    public Byte[] generate(Billing billing) {

        PDFContext pdfContext = context.getPdfContext();
        pdfContext.setDocument(new PDDocument());

        try {
            IWorker worker = context.getFactory().getWorker(layout.getHead());
            worker.flush();
            pdfContext.getDocument().close();
        } catch (Exception ex) {
            logger.error(ex);
        }

        return new Byte[0];
    }
}
