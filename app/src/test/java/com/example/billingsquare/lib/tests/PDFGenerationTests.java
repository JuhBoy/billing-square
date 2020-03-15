package com.example.billingsquare.lib.tests;

import com.square.billingcore.converters.JsonConverter;
import com.square.billingcore.generators.PDFDataLayout;
import com.square.billingcore.generators.PDFGenerator;
import com.square.billingcore.generators.models.ContainerNode;
import com.square.billingcore.generators.workers.formatters.BillingMappingIdContext;
import com.square.billingcore.logging.ConsoleLogger;
import com.square.billingcore.models.Address;
import com.square.billingcore.models.Billing.Billing;
import com.square.billingcore.models.Billing.Description;
import com.square.billingcore.models.Billing.Row;
import com.square.billingcore.models.Contact;
import com.square.billingcore.models.Customer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PDFGenerationTests {

    @Test
    public void should_build_generator() {
        Billing billing = buildCustomBilling();
        BillingMappingIdContext context = new BillingMappingIdContext(billing);
        PDFGenerator generator = new PDFGenerator(buildLayout(), context, new ConsoleLogger());

        Byte[] data = generator.generate(billing);
    }

    @Test
    public void should_convert_using_node_adapter() {
        JsonConverter<PDFDataLayout> converter = new JsonConverter<>(PDFDataLayout.class);

        ContainerNode node = new ContainerNode();
        node.setBlockIndex(32);

        PDFDataLayout layout = new PDFDataLayout();
        layout.setHead(node);
        layout.setFileName("Mfilename.json");

        try {
            String layoutAsJsonStr = converter.serialize(layout);
            Assert.assertNotNull(layoutAsJsonStr);

            PDFDataLayout layoutDes = converter.deserialize(layoutAsJsonStr);
            Assert.assertTrue(layoutDes.getHead() instanceof ContainerNode);
            Assert.assertEquals(((ContainerNode)layoutDes.getHead()).getBlockIndex(), 32);
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
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
