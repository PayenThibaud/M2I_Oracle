package packageReport;


import packageBook.Book;
import packageInventory.BookInventory;

import java.util.HashMap;

public class InventoryReport {

    private BookInventory bookInventory;

    public InventoryReport(BookInventory inventory) {
        bookInventory = inventory;
    }

    public HashMap<Book, Boolean> getBookInventory() {
        return bookInventory.getBooks();
    }

}
