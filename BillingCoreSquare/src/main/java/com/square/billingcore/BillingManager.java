package com.square.billingcore;

import com.square.billingcore.logging.ConsoleLogger;
import com.square.billingcore.logging.ILogger;
import com.square.billingcore.storage.LocalFileStorage;
import com.square.billingcore.storage.FileStore;

public class BillingManager {

    static ILogger logger = new ConsoleLogger();

    public static FileStore getLocalFileStorage(String root) {
        return new LocalFileStorage(root, BillingManager.logger);
    }
}
