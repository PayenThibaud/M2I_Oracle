package org.example;

import java.util.Scanner;

public class Text implements IText {

    @Override
    public String transform() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un mot/phrase : ");
        String mot = scanner.nextLine();
        return mot;
    }
}
