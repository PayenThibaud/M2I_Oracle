package org.example.creational.composite;


import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
    private String name;
    private List<Component> content = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Component c) {
        content.add(c);
    }

    public void remove(Component c) {
        content.remove(c);
    }


    @Override
    public void operation() {
        System.out.println("Folder " + name );
        for (Component c : content) {
            c.operation();
        }
    }
}
