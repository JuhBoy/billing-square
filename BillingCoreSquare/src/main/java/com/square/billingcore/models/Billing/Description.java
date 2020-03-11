package com.square.billingcore.models.Billing;

        import java.util.ArrayList;

public class Description {

    private ArrayList<Row> records;

    public ArrayList<Row> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Row> records) {
        this.records = records;
    }
}
