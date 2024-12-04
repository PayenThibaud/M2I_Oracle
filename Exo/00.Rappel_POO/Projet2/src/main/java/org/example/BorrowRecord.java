package org.example;

public class BorrowRecord {

    private int itemId;
    private String borrowerName;
    private String borrowerDate;

    public BorrowRecord(int itemId, String borrowerName, String borrowerDate) {
        this.itemId = itemId;
        this.borrowerName = borrowerName;
        this.borrowerDate = borrowerDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord {" + " itemId= " + itemId + " borrowerName= " + borrowerName + " borrowerDate= " + borrowerDate +'}';
    }
}
