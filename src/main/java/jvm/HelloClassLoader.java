package jvm;

import util.Base64Util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloClassLoader extends ClassLoader{
    String path="C:\\Users\\paul\\Downloads\\aaa\\Hello.xlass";
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64= new Base64Util().readFile2Base64(path);
        byte[] bytes=decode(helloBase64);
        int i=0;
        for (byte a: bytes){
            bytes[i]= (byte) (255-a);
            i++;
        }
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getMimeDecoder().decode(base64);
    }



    public static void main(String[] args) {

        try{
        Class   w  =  new HelloClassLoader().findClass("Hello");
        w.getMethod("hello").invoke(w.getConstructor().newInstance() );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}
