package packageCheckout;

import java.util.HashMap;
import packageBook.Book;

public class CheckoutSystem {
    private HashMap<Book, Boolean> BookList = new HashMap<>();

    public void setBook(Book book) {
        BookList.put(book, true);
    }

    public void deleteBook(Book book) {
        BookList.remove(book);
    }

    public HashMap<Book, Boolean> getBookList() {
        return BookList;
    }

    public Boolean isDispo(Book book) {
        return BookList.get(book);
    }

    public void emprunterBook(Book book) {
        if(isDispo(book)) {
            BookList.put(book, false);
        }
        else {
            System.out.println("Livre non dispo pour un emprunt");
        }
    }

    public void retourBook(Book book) {
        if(!isDispo(book)) {
            BookList.put(book, true);
        }
        else {
            System.out.println("Le livre n a pas été emprunté");
        }
    }
}
