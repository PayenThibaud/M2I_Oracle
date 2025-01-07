package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        int nbJava = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader("texte.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Java")) {
                    nbJava++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            writer.write(String.valueOf(nbJava));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}