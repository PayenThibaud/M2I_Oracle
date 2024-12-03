import java.util.Scanner;

import Projet.Directory;
import Projet.User;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Directory directory = new Directory();

        User user1 = new User("Titi", "123");
        User user2 = new User("Toto", "456");
        User user3 = new User("Titi", "789");

        directory.addUser(user1);
        directory.addUser(user2);
        directory.addUser(user3);

        boolean boucle = true;

        while (boucle) {
            System.out.print("1 : Ajouter un contact\n2 : Lister les contacts\n3 : Chercher par le nom\n4 : quitter\n");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                System.out.println(" - Ajout d un nouveau contact -");
                System.out.println("Rentrer un nom :");
                String userName = scanner.nextLine();
                System.out.println("Rentrer un tel :");
                String userTel = scanner.nextLine();

                User newUser = new User(userName, userTel);

                directory.addUser(newUser);

                System.out.println("Nouveau Contact ajouter");

                    break;

                case "2":
                System.out.println(" - Liste des contacts -");
                System.out.println(directory.getAllUser());

                    break;

                case "3":
                System.out.println(" - Rechercher par nom -");
                System.out.println("Rentrer un nom a rechercher :");
                String userNameFind = scanner.nextLine();
                System.out.println(directory.GetUserByName(userNameFind));


                    break;

                case "4":
                System.out.println("Bye");
                boucle = false;

                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }

        }
    }
}