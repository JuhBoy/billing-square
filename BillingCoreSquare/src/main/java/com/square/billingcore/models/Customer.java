package com.square.billingcore.models;

public final class Customer {

    private String name;
    private Address address;
    private Contact contact;

    private Customer() { }

    public class Builder {

        private String mName;
        private Address mAddress;
        private Contact mContact;

        public Builder() {
            mName = "N/A";
            mAddress = new Address("", "", "","");
            mContact = new Contact("", "");
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setAddress(Address address) {
            this.mAddress = address;
            return this;
        }

        public Builder setContact(Contact contact) {
            mContact = contact;
            return this;
        }

        public Customer Build() {
            Customer customer = new Customer();
            customer.name = mName;
            customer.address = mAddress;
            customer.contact = mContact;

            return customer;
        }
    }

    /**
     * Only for debugging purposes
     * Looks for CustomerSerializer for Json/Text serialization
     * @return A string representing the Customer
     */
    @Override public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("===============================");
        builder.append(Customer.class.toString() + '\n');
        builder.append("name: " + name + '\n');
        builder.append("address: " + address.toString() + '\n');
        builder.append("contact: " + contact.toString() + '\n');
        builder.append("===============================");

        return builder.toString();
    }
}
