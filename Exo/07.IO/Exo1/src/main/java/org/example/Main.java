package org.example;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        int nbJava = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("texte.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (Pattern.matches(".*\\b[Jj]ava\\b.*", line)) {
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