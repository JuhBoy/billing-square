package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.generators.models.Node;

public class ContainerWorker extends Worker<Node> {

    public ContainerWorker(ContainerNode model, WorkerContext context) {
        super(model, context);
    }

    @Override
    public void flush() {
        context.getContainerParents().push((ContainerNode) model);
        Node current = model.getChild();

        while (current != null) {
            IWorker worker = context.getFactory().getWorker(current);
            worker.flush();
            current = current.getNext();
        }

        context.getContainerParents().pop();
    }
}
