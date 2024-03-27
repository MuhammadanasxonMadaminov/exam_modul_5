package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Task1 {
    public static void main(String[] args) {

        try {
            FileInputStream in = new FileInputStream("resource/music.mp3");
            FileOutputStream out = new FileOutputStream("resource/encodingText");

//            System.out.println(in);
            byte[] bytes = in.readAllBytes();

            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encode = encoder.encode(bytes);
//            System.out.println("encode = " + Arrays.toString(encode));
            out.write(encode);
            out.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
