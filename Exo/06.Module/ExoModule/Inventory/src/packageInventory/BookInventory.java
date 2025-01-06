package packageInventory;

import packageCheckout.CheckoutSystem;

import java.util.HashMap;

import packageBook.Book;

public class BookInventory {

    private CheckoutSystem checkoutSystem;

    public BookInventory(CheckoutSystem checkoutSystem) {
        this.checkoutSystem = checkoutSystem;
    }

    public HashMap<Book, Boolean> getBooks() {
        HashMap<Book, Boolean> bookList = checkoutSystem.getBookList();

        return bookList;
    }

    public void setBooks(Book book) {
        checkoutSystem.setBook(book);
    }

    public void deleteBook(Book book) {
        checkoutSystem.deleteBook(book);
    }


}
