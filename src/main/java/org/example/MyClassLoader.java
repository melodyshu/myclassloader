package org.example;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR= Paths.get("C:","classloader1");
    private final Path classDir;
    public MyClassLoader(){
        super();
        this.classDir=DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir){
        super();
        this.classDir=Paths.get(classDir);
    }

    public MyClassLoader(String classDir,ClassLoader parent){
        super(parent);
        this.classDir=Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       byte[] classBytes= this.readClassBytes(name);
       if (classBytes == null || classBytes.length == 0){
           throw new ClassNotFoundException("找不到类");
       }
        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        byte[] bytes=null;
        String classPath=name.replace(".","\\");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("class "+name+" not found.");
        }

        try(ByteArrayOutputStream baos=new ByteArrayOutputStream()){
            Files.copy(classFullPath,baos);
            bytes= baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bytes;
    }


}
