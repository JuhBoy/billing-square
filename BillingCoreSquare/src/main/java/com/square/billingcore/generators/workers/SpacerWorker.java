package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.Node;

public class SpacerWorker extends Worker<Node> {

    public SpacerWorker(Node model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {

    }
}
