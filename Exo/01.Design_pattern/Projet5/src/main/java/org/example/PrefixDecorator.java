package org.example;

import java.util.Scanner;

public class PrefixDecorator extends TextDecorator {

    public PrefixDecorator(IText text) {
        super(text);
    }

    public String getPrefix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un préfixe : ");
        String prefix = scanner.nextLine();
        return prefix;
    }

    @Override
    public String transform(){
        return  getPrefix() + text.transform() ;
    }
}
