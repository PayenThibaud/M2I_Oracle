package org.example;

import java.io.*;

public class BinaryFileHander {

    public void demonstrateBinaryFileHander() {

        System.out.println("demo binary file hander");
        String srcFilePath = "source.dat";
        String destFilePath = "dest.dat";

        // creation du fichier binaire
        try (FileOutputStream out = new FileOutputStream(srcFilePath)) {
            out.write(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            System.out.println("Fichier binaire crée");

        } catch (IOException e){
            e.printStackTrace();
        }

        // copie du fichier
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFilePath));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFilePath))) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
