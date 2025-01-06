package packageApp;

import packageBook.Book;
import packageCheckout.CheckoutSystem;
import packageInventory.BookInventory;
import packageNotification.INotificationService;
import packageReport.InventoryReport;

import java.util.ServiceLoader;


public class LibraryApp {
    public static void main(String[] args) {

        CheckoutSystem checkoutSystem = new CheckoutSystem();
        BookInventory bookInventory = new BookInventory(checkoutSystem);
        InventoryReport inventoryReport = new InventoryReport(bookInventory);

        Book book1 = new Book(1, "Titre1", "auteur1");
        Book book2 = new Book(2, "Titre2", "auteur2");
        Book book3 = new Book(3, "Titre3", "auteur3");
        Book book4 = new Book(4, "Titre4", "auteur4");
        Book book5 = new Book(5, "Titre5", "auteur5");

        bookInventory.setBooks(book1);
        bookInventory.setBooks(book2);
        bookInventory.setBooks(book3);
        bookInventory.setBooks(book4);
        bookInventory.setBooks(book5);

        System.out.println(inventoryReport.getBookInventory());

        bookInventory.deleteBook(book1);

        System.out.println(inventoryReport.getBookInventory());

        checkoutSystem.emprunterBook(book2);

        checkoutSystem.emprunterBook(book3);
        checkoutSystem.emprunterBook(book3);

        checkoutSystem.retourBook(book3);
        checkoutSystem.retourBook(book3);

        System.out.println(inventoryReport.getBookInventory());

        String message = "Salut";

        System.out.println(useEmailNotif(message));
        System.out.println(useSmsNotif(message));

    }

    public static String useEmailNotif(String message) {
        return ServiceLoader.load(INotificationService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .filter(service -> service.getClass().getName().contains("Email"))
                .findFirst()
                .map(service -> service.sendNotification(message))
                .orElse("Email service not found");

    }

    public static String useSmsNotif(String message) {
        return ServiceLoader.load(INotificationService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .filter(service -> service.getClass().getName().contains("Sms"))
                .findFirst()
                .map(service -> service.sendNotification(message))
                .orElse("Sms service not found");

    }
}