package com.square.billingcore.generators.workers;

public abstract class Worker<T> implements IWorker {

    protected T model;
    protected WorkerContext context;

    public Worker(T model, WorkerContext context) {
        this.model = model;
        this.context = context;
    }

    public abstract void flush();
}
