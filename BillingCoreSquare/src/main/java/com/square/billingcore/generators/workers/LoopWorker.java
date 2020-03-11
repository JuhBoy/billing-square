package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.Node;

public class LoopWorker extends Worker<Node> {

    public LoopWorker(Node model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {

    }
}
