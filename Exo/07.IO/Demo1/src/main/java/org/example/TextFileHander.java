package org.example;

import java.io.*;

public class TextFileHander {

    public void demoTextFileOperation(){
        System.out.println("Demo Text File Operation");
        String filePath = "demo.txt";

        // Ecriture

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello World");
            writer.newLine();
            writer.write("couco \n");
            writer.write("slt");
        } catch (IOException e){
            e.printStackTrace();
        }


        // Lecture
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("ligne lue : " + line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
