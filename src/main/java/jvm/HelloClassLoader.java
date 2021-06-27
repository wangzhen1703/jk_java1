package jvm;

import util.Base64Util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //String helloBase64= new Base64Util().readFile2Base64(path);
        String helloBase64="yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUB\n" +
                "AA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgH\n" +
                "ABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5n\n" +
                "L09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsB\n" +
                "ABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAh\n" +
                "AAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQAL\n" +
                "AAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN";
        byte[] bytes=decode(helloBase64);
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
