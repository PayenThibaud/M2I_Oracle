package org.example;

public class UpperCaseDecorator extends TextDecorator {

    public UpperCaseDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform(){
        System.out.println("MAJ : ");
        return text.transform().toUpperCase();
    }
}
