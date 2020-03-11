package com.square.billingcore.generators.workers.accessors;

public class BillingAccessors {

    public enum BlockMap {
        FILE_INFOS(1),
        CUSTOMER(2),
        IMAGE_INFOS(3),
        OBJECT_DATA(4),
        DESCRIPTION(5),
        CGU(6);

        int i;

        BlockMap(int i) {
            this.i = i;
        }

        public int getAsIndex() {
            return i;
        }

        public BlockMap from(int i) {
            switch (i) {
                case 1:
                    return BlockMap.FILE_INFOS;
                case 2:
                    return BlockMap.CUSTOMER;
                case 3:
                    return BlockMap.IMAGE_INFOS;
                case 4:
                    return BlockMap.OBJECT_DATA;
                case 5:
                    return BlockMap.DESCRIPTION;
                case 6:
                    return BlockMap.CGU;
                default:
                    return null;
            }
        }
    }

    public enum FieldsMap {
        // FILE_INFOS:
        FILE_NAME(1),

        // CUSTOMER START =========================

            CUSTOMER_NAME(2),

            // ADDRESS
            CUSTOMER_STREET(3),
            CUSTOMER_CITY(4),
            CUSTOMER_POSTAL_CODE(5),
            CUSTOMER_COUNTRY(6),

            // CONTACT
            CUSTOMER_LAST_NAME(7),
            CUSTOMER_FIRST_NAME(8),
            CUSTOMER_PHONE_NUMBER(9),
            CUSTOMER_EMAIL(10),

        // CUSTOMER END =========================

        // SENDER START =========================

            SENDER_NAME(11),

            // ADDRESS
            SENDER_STREET(12),
            SENDER_CITY(13),
            SENDER_POSTAL_CODE(14),
            SENDER_COUNTRY(15),

            // CONTACT
            SENDER_LAST_NAME(16),
            SENDER_FIRST_NAME(17),
            SENDER_PHONE_NUMBER(18),
            SENDER_EMAIL(19),

        // CUSTOMER END =========================

        // IMAGES_INFOS
        LOGO_PATH(20),

        // OBJECT_DATA
        OBJECT_BODY(21),
        OBJECT_REFERENCE(22),
        OBJECT_ADDITIONAL_DETAILS(23),
        OBJECT_DETAILS_KEY(24),
        OBJECT_DETAILS_VALUE(25),

        // DESCRIPTIONS
        DESCRIPTION(26),

        // DESCRIPTION_ROW
        DESC_TITLE(27),
        DESC_CONTENT(28),
        DESC_QUANTITY(29),
        DESC_PRICE(30),
        DESC_AMOUNT(31),
        DESC_DISCOUNT(32),

        // CGU
        CGU_TITLE(33),
        CGU_CONTENT(34);

        int index;

        FieldsMap(int index) {
            this.index = index;
        }

        public int getAsIndex() {
            return this.index;
        }
    }
}
