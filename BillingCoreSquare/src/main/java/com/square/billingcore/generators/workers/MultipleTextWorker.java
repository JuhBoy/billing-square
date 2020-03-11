package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.models.Billing.Billing;

public class MultipleTextWorker extends ContainerWorker {

    public MultipleTextWorker(ContainerNode model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {

    }
}
