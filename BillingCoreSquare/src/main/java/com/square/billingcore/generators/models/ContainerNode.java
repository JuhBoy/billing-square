package com.square.billingcore.generators.models;

public class ContainerNode extends Node {

    /**
     * Index that allow to map containers to Billing blocks
     * (Like: CGU/Description etc.)
     */
    private int blockIndex;

    public int getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(int blockIndex) {
        this.blockIndex = blockIndex;
    }
}
