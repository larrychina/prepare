package org.larry.normal.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;

public class OwnDefinedClassLoader extends ClassLoader {

    private String classPath;

    public OwnDefinedClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileDir = name.replaceAll("[.]", Matcher.quoteReplacement(File.separator)).concat(".class");
        this.classPath = this.getClassPath().endsWith(Matcher.quoteReplacement(File.separator)) ? this.getClassPath() : this.getClassPath().concat(Matcher.quoteReplacement(File.separator));
        String classFileUrl = this.getClassPath().concat(classFileDir);
        try (InputStream inputStream = new FileInputStream(classFileUrl)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return super.defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public OwnDefinedClassLoader() {
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new OwnDefinedClassLoader() ;
        Object obj = myLoader.loadClass("org.larry.normal.classloader.OwnDefinedClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof org.larry.normal.classloader.OwnDefinedClassLoader);
    }
}
