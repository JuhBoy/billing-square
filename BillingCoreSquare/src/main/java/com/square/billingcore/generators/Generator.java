package com.square.billingcore.generators;

public abstract class Generator<TInModel, EOutModel> {

    public Generator() { }

    public abstract EOutModel generate(TInModel inModel);
}
