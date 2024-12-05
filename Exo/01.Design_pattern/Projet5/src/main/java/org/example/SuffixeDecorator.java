package org.example;

import java.util.Scanner;

public class SuffixeDecorator extends TextDecorator {

    public SuffixeDecorator(IText text) {
        super(text);
    }

    public String getSuffixe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un suffixe : ");
        String suffixe = scanner.nextLine();
        return suffixe;
    }

    @Override
    public String transform() {
        return   text.transform() + getSuffixe();
    }

}
