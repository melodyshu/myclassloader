package org.example;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String text=Utils.base64Encoder("中国人");
        Utils.base64Decoder(text);

        String className="C:\\classloader1\\org\\example\\HelloWorld.class";
        String content=Utils.base64EncoderString(className);
        FileWriter fileWriter = new FileWriter(className);
        fileWriter.write(content);
        fileWriter.flush();
        Utils.base64DecoderByte(content);
    }
}
