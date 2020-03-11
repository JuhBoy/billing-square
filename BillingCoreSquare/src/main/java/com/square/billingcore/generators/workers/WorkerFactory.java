package com.square.billingcore.generators.workers;

import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.generators.models.ImageLog;
import com.square.billingcore.generators.models.LoopNode;
import com.square.billingcore.generators.models.MultipleTextNode;
import com.square.billingcore.generators.models.Node;
import com.square.billingcore.generators.models.SpacerNode;
import com.square.billingcore.generators.models.TextNode;

public class WorkerFactory {

    private WorkerContext context;

    public WorkerFactory(WorkerContext context) {
        this.context = context;
    }

    public IWorker getWorker(Node node) {
        if (node instanceof LoopNode) {
            return new LoopWorker(node, context);
        } else if (node instanceof MultipleTextNode) {
            return new MultipleTextWorker((MultipleTextNode) node, context);
        } else if (node instanceof ContainerNode) {
            return new ContainerWorker((ContainerNode)node, context);
        } else if (node instanceof ImageLog) {
            return new LogoWorker(node, context);
        } else if (node instanceof SpacerNode) {
            return new SpacerWorker(node, context);
        } else if (node instanceof TextNode) {
            return new TextWorker(node, context);
        } else {
            return null;
        }
    }
}
