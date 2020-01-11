package org.example;

import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader=new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("org.example.HelloWorld");
        System.out.println(aClass.getClassLoader());
        Object hellworld = aClass.newInstance();
        System.out.println(hellworld);
        Method welcome = aClass.getMethod("welcome");
        String result = (String) welcome.invoke(hellworld);
        System.out.println("Result:"+result);

    }
}
