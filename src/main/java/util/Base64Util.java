package util;

import cn.hutool.core.io.file.FileReader;

import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;

public class Base64Util {

    static String path="C:\\Users\\";

    public String readFile2Base64 (String path){
        FileReader fileReader = new FileReader(path);
        byte[] a =fileReader.readBytes();
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(a);
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
        return mimeEncodedString;
    }

    public static void main(String args[]){
        new Base64Util().readFile2Base64(path);
    }


}
