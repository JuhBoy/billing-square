package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.generators.workers.formatters.MappingIdContext;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.util.Stack;

public class WorkerContext {

    private WorkerFactory factory;
    private MappingIdContext mappingContext;
    private PDFContext pdfContext;
    private Stack<ContainerNode> containerParents;

    public WorkerContext() {
        containerParents = new Stack<>();
    }

    public PDFContext getPdfContext() {
        return pdfContext;
    }

    public void setPdfContext(PDFContext pdfContext) {
        this.pdfContext = pdfContext;
    }

    public WorkerFactory getFactory() {
        return factory;
    }

    public void setFactory(WorkerFactory factory) {
        this.factory = factory;
    }

    public Stack<ContainerNode> getContainerParents() {
        return containerParents;
    }

    public MappingIdContext getMappingContext() {
        return mappingContext;
    }

    public void setMappingContext(MappingIdContext mappingContext) {
        this.mappingContext = mappingContext;
    }

    public void setContainerParents(Stack<ContainerNode> containerParents) {
        this.containerParents = containerParents;
    }
}


