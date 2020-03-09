package com.example.billingsquare.lib.tests;

import com.square.billingcore.BillingController;
import com.square.billingcore.management.BillingManager;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.storage.FileStore;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

final public class BillingManagerTests {

    @Test
    public void should_create_billing_through_manager() {
        try {
            String root = Paths.get(new File(".").getCanonicalPath(), "src", "test", "res").toFile().getCanonicalPath();
            BillingManager manager = BillingController.getManager(root, BillingController.StoreType.LOCAL);

            String fileName = "billing-contract-test.json";
            Billing billing = manager.create(fileName);

            FileStore fileStore = BillingController.getLocalFileStorage(root);
            byte[] data = fileStore.get(fileName);

            Assert.assertNotNull(billing);
            Assert.assertNotNull(data);
            Assert.assertTrue(data.length > 0);

            fileStore.remove(fileName);
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
    }
}
