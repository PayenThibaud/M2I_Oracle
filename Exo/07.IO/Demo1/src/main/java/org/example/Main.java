package org.example;

public class Main {
    public static void main(String[] args) {

        TextFileHander textFileHander = new TextFileHander();
        textFileHander.demoTextFileOperation();

        BinaryFileHander binaryFileHander = new BinaryFileHander();
        binaryFileHander.demonstrateBinaryFileHander();
    }
}