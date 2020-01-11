package org.example;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Utils {
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Base64.Encoder encoder = Base64.getEncoder();

    public static String base64Encoder(String content) throws Exception {

        final byte[] textByte = content.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        return  encodedText;
    }

    public static String base64Decoder(String content) throws Exception {

        //解码
        String decodedText=new String(decoder.decode(content), "UTF-8");
        System.out.println(decodedText);
        return decodedText;
    }

    public static String base64EncoderString(String className) throws Exception {

        //编码
        byte[] bytes=null;
        Path fullPath = Paths.get(className);
        try(ByteArrayOutputStream baos=new ByteArrayOutputStream()){
            Files.copy(fullPath,baos);
            bytes= baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        String encodedText=encoder.encodeToString(bytes);
        System.out.println(encodedText);
        return  encodedText;
    }

    public static byte[] base64DecoderByte(String content) throws Exception {

        //解码
        return decoder.decode(content);
    }

}
