package com.square.billingcore.storage;

import java.io.File;

public abstract class FileStore {

    protected String rootPath;

    FileStore(String rootPath) {
        this.rootPath = rootPath;
    }

    abstract public byte[] get(String name) throws Exception;
    abstract public void save(String name, byte[] data) throws Exception;
    abstract public boolean remove(String name);
    abstract public boolean exists(String name);

    @Override public String toString() {
        return super.toString() + " " + "Root Path: " + this.rootPath;
    }

    protected String sanitize(String name) {
        return name.replaceAll("[:\\\\/*?|<>]", "_");
    }

    protected boolean Exists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
