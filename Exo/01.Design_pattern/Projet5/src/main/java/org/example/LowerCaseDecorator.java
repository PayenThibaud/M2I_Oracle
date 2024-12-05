package org.example;

public class LowerCaseDecorator extends TextDecorator {

    public LowerCaseDecorator(IText text) {
        super(text);
    }

    @Override
    public String transform(){
        System.out.println("MIN :");
        return text.transform().toLowerCase();
    }
}
