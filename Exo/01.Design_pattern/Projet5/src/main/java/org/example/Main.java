package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        IText text = new Text();

        System.out.println(text.transform());

        IText text2 = new LowerCaseDecorator(text);
        System.out.println(text2.transform());

        IText text3 = new UpperCaseDecorator(text);
        System.out.println(text3.transform());

        IText text4 = new PrefixDecorator(text);
        System.out.println(text4.transform());

        IText text5 = new SuffixeDecorator(text);
        System.out.println(text5.transform());

    }
}