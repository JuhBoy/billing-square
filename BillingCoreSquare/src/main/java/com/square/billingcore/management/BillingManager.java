package com.square.billingcore.management;

import com.square.billingcore.converters.Converter;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.storage.FileStore;

public final class BillingManager implements IBillingManager {

    private FileStore fileStore;
    private Converter<Billing> converter;

    public BillingManager(FileStore store, Converter<Billing> converter) throws Exception {
        setFileStore(store);
        setConverter(converter);
    }

    public void setFileStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    public void setConverter(Converter<Billing> converter) throws Exception {
        if (converter.getInnerType() != Billing.class)
            throw new Exception("Type of the converter mismatch (Billing required)");
        this.converter = converter;
    }

    /// API

    @Override
    public Billing create(String fileName) throws Exception {
        Billing billing = new Billing(fileName);
        String format = this.converter.serialize(billing);
        fileStore.save(fileName, format.getBytes());

        return billing;
    }

    @Override
    public Billing load(String fileName) throws Exception {
        byte[] data = this.fileStore.get(fileName);
        String body = new String(data, "UTF-8");
        return this.converter.deserialize(body);
    }

    @Override
    public String[] getAvailable() throws Exception {
        return this.fileStore.getAll();
    }

    @Override
    public void update(Billing billing) throws Exception {
        String fileName = billing.getFileInfos().getFileName();
        this.fileStore.remove(fileName);

        byte[] data = this.converter.serialize(billing).getBytes();
        this.fileStore.save(billing.getFileInfos().getFileName(), data);
    }

    @Override
    public boolean remove(Billing billing) {
        return this.fileStore.remove(billing.getFileInfos().getFileName());
    }

    @Override
    public boolean exists(String identifier) throws Exception {
        return this.fileStore.exists(identifier);
    }
}
