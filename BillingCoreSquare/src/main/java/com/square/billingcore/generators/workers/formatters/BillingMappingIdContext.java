package com.square.billingcore.generators.workers.formatters;

import com.square.billingcore.generators.workers.accessors.BillingAccessors;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.models.Billing.CGU;
import com.square.billingcore.models.Billing.Description;
import com.square.billingcore.models.Billing.FileInfos;
import com.square.billingcore.models.Billing.ImageInfos;
import com.square.billingcore.models.Billing.ObjectData;
import com.square.billingcore.models.Billing.ObjectDetail;
import com.square.billingcore.models.Billing.Row;
import com.square.billingcore.models.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class BillingMappingIdContext extends MappingIdContext<Billing> {

    public BillingMappingIdContext(Billing model) {
        super(model);
        generateMap();
    }

    private void generateMap() {
        if (model.getFileInfos() != null)
            generateFileInfos();
        if (model.getCustomer() != null)
            generateCustomer();
        if (model.getSender() != null)
            generateSender();
        if (model.getLogo() != null)
            generateImageInfos();
        if (model.getObject() != null)
            generateObjectData();
        if (model.getDescription() != null)
            generateDescription();
        if (model.getCgu() != null)
            generateCGU();
    }

    private void generateCGU() {
        CGU cgu = model.getCgu();

        int index = BillingAccessors.FieldsMap.CGU_TITLE.getAsIndex();
        put(index, cgu.getTitle());

        index = BillingAccessors.FieldsMap.CGU_CONTENT.getAsIndex();
        put(index, cgu.getContent());
    }

    private void generateDescription() {
        Description description = model.getDescription();

        int index = BillingAccessors.FieldsMap.DESCRIPTION.getAsIndex();
        ArrayList<HashMap<Integer, String>> rows = new ArrayList<>(description.getRecords().size());

        int title = BillingAccessors.FieldsMap.DESC_TITLE.getAsIndex();
        int amount = BillingAccessors.FieldsMap.DESC_AMOUNT.getAsIndex();
        int content = BillingAccessors.FieldsMap.DESC_CONTENT.getAsIndex();
        int discount = BillingAccessors.FieldsMap.DESC_DISCOUNT.getAsIndex();
        int price = BillingAccessors.FieldsMap.DESC_PRICE.getAsIndex();
        int quantity = BillingAccessors.FieldsMap.DESC_QUANTITY.getAsIndex();

        for (Row row : description.getRecords()) {
            HashMap<Integer, String> hash = new HashMap<>(6);
            hash.put(title, row.getTitle());
            hash.put(content, row.getContent());
            hash.put(amount, String.valueOf(row.getAmount()));
            hash.put(discount, String.valueOf(row.getDiscount()));
            hash.put(price, String.valueOf(row.getPrice()));
            hash.put(quantity, String.valueOf(row.getQuantity()));
            rows.add(hash);
        }

        put(index, rows);
    }

    private void generateObjectData() {
        ObjectData object = model.getObject();

        int index = BillingAccessors.FieldsMap.OBJECT_BODY.getAsIndex();
        put(index, object.getObject());

        index = BillingAccessors.FieldsMap.OBJECT_REFERENCE.getAsIndex();
        put(index, object.getReference());

        index = BillingAccessors.FieldsMap.OBJECT_ADDITIONAL_DETAILS.getAsIndex();
        ArrayList<HashMap<Integer, String>> details = new ArrayList<>(object.getDetails().size());

        int keyIndex = BillingAccessors.FieldsMap.OBJECT_DETAILS_KEY.getAsIndex();
        int valueIndex = BillingAccessors.FieldsMap.OBJECT_DETAILS_VALUE.getAsIndex();

        for (ObjectDetail detail : object.getDetails()) {
            HashMap<Integer, String> hash = new HashMap<>(2);
            hash.put(keyIndex, detail.key);
            hash.put(valueIndex, detail.value);
            details.add(hash);
        }

        put(index, details);
    }

    private void generateImageInfos() {
        ImageInfos info = model.getLogo();

        int index = BillingAccessors.FieldsMap.LOGO_PATH.getAsIndex();
        put(index, info.getPath());
    }

    private void generateSender() {
        Customer sender = model.getCustomer();

        int index = BillingAccessors.FieldsMap.SENDER_NAME.getAsIndex();
        this.put(index, sender.getName());

        index = BillingAccessors.FieldsMap.SENDER_CITY.getAsIndex();
        this.put(index, sender.getAddress().getCity());

        index = BillingAccessors.FieldsMap.SENDER_COUNTRY.getAsIndex();
        this.put(index, sender.getAddress().getCountry());

        index = BillingAccessors.FieldsMap.SENDER_EMAIL.getAsIndex();
        put(index, sender.getContact().getEmail());

        index = BillingAccessors.FieldsMap.SENDER_FIRST_NAME.getAsIndex();
        put(index, sender.getContact().getFirstName());

        index = BillingAccessors.FieldsMap.SENDER_PHONE_NUMBER.getAsIndex();
        put(index, sender.getContact().getPhoneNumber());

        index = BillingAccessors.FieldsMap.SENDER_LAST_NAME.getAsIndex();
        put(index, sender.getContact().getLastName());

        index = BillingAccessors.FieldsMap.SENDER_POSTAL_CODE.getAsIndex();
        put(index, sender.getAddress().getPostalCode());

        index = BillingAccessors.FieldsMap.SENDER_STREET.getAsIndex();
        put(index, sender.getAddress().getStreet());
    }

    private void generateCustomer() {
        Customer customer = model.getCustomer();

        int index = BillingAccessors.FieldsMap.CUSTOMER_NAME.getAsIndex();
        this.put(index, customer.getName());

        index = BillingAccessors.FieldsMap.CUSTOMER_CITY.getAsIndex();
        this.put(index, customer.getAddress().getCity());

        index = BillingAccessors.FieldsMap.CUSTOMER_COUNTRY.getAsIndex();
        this.put(index, customer.getAddress().getCountry());

        index = BillingAccessors.FieldsMap.CUSTOMER_EMAIL.getAsIndex();
        put(index, customer.getContact().getEmail());

        index = BillingAccessors.FieldsMap.CUSTOMER_FIRST_NAME.getAsIndex();
        put(index, customer.getContact().getFirstName());

        index = BillingAccessors.FieldsMap.CUSTOMER_PHONE_NUMBER.getAsIndex();
        put(index, customer.getContact().getPhoneNumber());

        index = BillingAccessors.FieldsMap.CUSTOMER_LAST_NAME.getAsIndex();
        put(index, customer.getContact().getLastName());

        index = BillingAccessors.FieldsMap.CUSTOMER_POSTAL_CODE.getAsIndex();
        put(index, customer.getAddress().getPostalCode());

        index = BillingAccessors.FieldsMap.CUSTOMER_STREET.getAsIndex();
        put(index, customer.getAddress().getStreet());
    }

    private void generateFileInfos() {
        int index = BillingAccessors.FieldsMap.FILE_NAME.getAsIndex();
        FileInfos data = model.getFileInfos();
        this.put(index, data.getFileName());
    }


}
