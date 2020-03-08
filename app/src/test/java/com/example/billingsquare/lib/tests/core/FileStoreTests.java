package com.example.billingsquare.lib.tests.core;

import com.square.billingcore.BillingManager;
import com.square.billingcore.storage.FileStore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * File Store tests, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FileStoreTests {
    @Test
    public void should_get_file() {
        try {
            FileStore fileStore = BillingManager.getLocalFileStorage("./");

            byte[] fileData = fileStore.get("fake-file.json");

            Assert.assertNotNull(fileData);
            Assert.assertNotEquals(new byte[0], fileData);
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
    }
}