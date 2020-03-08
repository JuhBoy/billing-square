package com.square.billingcore.logging;

public interface ILogger {
    void warn(Exception ex);
    void error(Exception ex);
    void info(Exception ex);

    void warn(String data);
    void error(String data);
    void info(String data);
}
