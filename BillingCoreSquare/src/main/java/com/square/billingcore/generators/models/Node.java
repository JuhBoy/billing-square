package com.square.billingcore.generators.models;

import com.square.billingcore.converters.NodeSerializer;

import java.awt.geom.Point2D;

public abstract class Node extends NodeSerializer {
    private Point2D position;
    private Node child;
    private Node next;

    private int mapId;

    private boolean isStaticContent;
    private Object staticContent;

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isStaticContent() {
        return isStaticContent;
    }

    public void setStaticContent(boolean staticContent) {
        isStaticContent = staticContent;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public Object getStaticContent() {
        return staticContent;
    }

    public void setStaticContent(Object staticContent) {
        this.staticContent = staticContent;
    }
}
