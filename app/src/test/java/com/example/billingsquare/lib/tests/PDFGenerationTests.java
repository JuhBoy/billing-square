package com.example.billingsquare.lib.tests;

import com.square.billingcore.BillingController;
import com.square.billingcore.generators.PDFDataLayout;
import com.square.billingcore.generators.PDFGenerator;
import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.generators.models.Node;
import com.square.billingcore.generators.models.PageNode;
import com.square.billingcore.generators.models.TextNode;
import com.square.billingcore.generators.workers.formatters.BillingMappingIdContext;
import com.square.billingcore.generators.workers.formatters.MappingIdContext;
import com.square.billingcore.logging.ConsoleLogger;
import com.square.billingcore.models.Address;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.models.Billing.Description;
import com.square.billingcore.models.Billing.FileInfos;
import com.square.billingcore.models.Billing.Row;
import com.square.billingcore.models.Contact;
import com.square.billingcore.models.Customer;
import com.square.billingcore.storage.FileStore;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PDFGenerationTests {

    @Test
    public void should_build_generator() {
        Billing billing = buildCustomBilling();
        BillingMappingIdContext context = new BillingMappingIdContext(billing);
        PDFGenerator generator = new PDFGenerator(buildLayout(), context, new ConsoleLogger());

        Byte[] data = generator.generate(billing);
    }

    private PDFDataLayout buildLayout() {
        PDFDataLayout layout = new PDFDataLayout();

        layout.setFileName("toto.png");

        ContainerNode head = new ContainerNode();

        layout.setHead(head);

        return layout;
    }

    private Billing buildCustomBilling() {
        Billing billing = new Billing("myfilename.json");

        Address address = new Address("8 rue albert", "Paris", "92600", "France");
        Contact contact = new Contact("Boyer", "julien");
        contact.setPhoneNumber("0619198695");
        contact.setEmail("julien.boyer@orange.fr");

        Customer customer = new Customer.Builder()
                .setAddress(address)
                .setName("PWeb & co")
                .setContact(contact)
                .Build();

        billing.setCustomer(customer);
        billing.setSender(customer);

        Description description = new Description();
        ArrayList<Row> records = new ArrayList<Row>();

        Row ar1 = new Row();
        ar1.setTitle("An item with good value");
        ar1.setContent("My super content of this item");
        ar1.setAmount(124);
        ar1.setPrice(1234);
        ar1.setQuantity(2);
        records.add(ar1);

        Row ar2 = new Row();
        ar2.setTitle("An item with good value");
        ar2.setContent("My super content of this item");
        ar2.setAmount(124);
        ar2.setPrice(1234);
        ar2.setQuantity(2);
        records.add(ar2);

        description.setRecords(records);

        billing.setDescription(description);

        return billing;
    }
}
