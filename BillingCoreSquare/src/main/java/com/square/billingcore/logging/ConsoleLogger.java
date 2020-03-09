package com.square.billingcore.logging;

public class ConsoleLogger implements ILogger {
    @Override
    public void warn(Exception ex) {
        this.warn(ex.getMessage());
    }

    @Override
    public void error(Exception ex) {
        this.error(ex.getMessage());
    }

    @Override
    public void info(Exception ex) {
        this.info(ex.getMessage());
    }

    @Override
    public void warn(String data) {
        System.out.println("");
        System.out.println("WARNING:");
        System.out.println(data);
        System.out.println("");
    }

    @Override
    public void error(String data) {
        System.out.println("");
        System.out.println("ERROR:");
        System.out.println(data);
        System.out.println("");
}
    @Override
    public void info(String data) {
        System.out.println("");
        System.out.println("INFO:");
        System.out.println(data);
        System.out.println("");
    }
}
