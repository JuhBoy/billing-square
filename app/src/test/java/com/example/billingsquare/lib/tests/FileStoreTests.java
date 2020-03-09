package com.example.billingsquare.lib.tests;

import com.square.billingcore.BillingController;
import com.square.billingcore.storage.FileStore;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

public class FileStoreTests {

    @Test
    public void should_get_file() {
        try {
            String root = Paths.get(new File(".").getCanonicalPath(), "src", "test", "res").toFile().getCanonicalPath();
            FileStore fileStore = BillingController.getLocalFileStorage(root);

            byte[] fileData = fileStore.get("fake-file.json");
            String body = new String(fileData, "UTF-8");

            Assert.assertNotNull(fileData);
            Assert.assertNotEquals(new byte[0], fileData);
            Assert.assertFalse(body.isEmpty());
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
    }

    @Test
    public void should_create_file() {
        try {
            String root = Paths.get(new File(".").getCanonicalPath(), "src", "test", "res").toFile().getCanonicalPath();
            FileStore fileStore = BillingController.getLocalFileStorage(root);

            String fileName = "tmp.test-file.create.json";

            fileStore.save(fileName, fileStore.get("fake-file.json"));

            Assert.assertTrue(Paths.get(root, fileName).toFile().exists());
            Assert.assertTrue(fileStore.remove(fileName));
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
    }
}
