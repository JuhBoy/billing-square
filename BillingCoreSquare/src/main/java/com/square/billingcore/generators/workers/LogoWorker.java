package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.Node;

public class LogoWorker extends Worker<Node> {

    public LogoWorker(Node model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {

    }
}
