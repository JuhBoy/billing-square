package com.square.billingcore;

import com.square.billingcore.converters.JsonConverter;
import com.square.billingcore.logging.ConsoleLogger;
import com.square.billingcore.logging.ILogger;
import com.square.billingcore.management.BillingManager;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.models.Customer;
import com.square.billingcore.storage.LocalFileStorage;
import com.square.billingcore.storage.FileStore;

import static com.square.billingcore.BillingController.StoreType.*;

public class BillingController {

    public enum StoreType {
        LOCAL(1),
        DRIVE(2),
        CLOUD(3);

        int number = 1;

        StoreType(int number) {
            this.number = number;
        }
    }

    static ILogger logger = new ConsoleLogger();

    public static BillingManager getManager(String rootDirectoryPath, StoreType storageType) throws Exception {
        FileStore store = getStore(rootDirectoryPath, storageType);
        return new BillingManager(store, new JsonConverter<>(Billing.class));
    }

    public static FileStore getLocalFileStorage(String root) {
        return new LocalFileStorage(root, BillingController.logger);
    }

    private static FileStore getStore(String rootDirectoryPath, StoreType storeType) {
        switch (storeType) {
            case CLOUD:
            case DRIVE:
                BillingController.logger.info("Cloud & Drive methods not implemented, fallback to local storage");
            case LOCAL:
            default:
                return BillingController.getLocalFileStorage(rootDirectoryPath);
        }
    }
}
