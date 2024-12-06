package org.example.creational.composite;

import java.awt.*;
import java.awt.image.ColorModel;

public class File implements Component {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("File " + name);
    }
}
