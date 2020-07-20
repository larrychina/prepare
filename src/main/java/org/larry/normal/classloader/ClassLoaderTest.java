package org.larry.normal.classloader;

import java.io.File;

public class ClassLoaderTest {
    /*** 双亲委派模型验证 * @param args * @throws ClassNotFoundException */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        OwnDefinedClassLoader myClassLoader1 = new OwnDefinedClassLoader("/D:/suningCode/prepare/");
        Class<?> aClass = myClassLoader1.loadClass("org.larry.normal.classloader.A");
        aClass.newInstance();
        System.out.println(aClass.getClassLoader());//UserClassLoader
        System.out.println(aClass.getClassLoader());//AppClassLoader
        System.out.println(aClass.getClassLoader().getParent());//ExtC lassLoader
        System.out.println(aClass.getClassLoader().getParent().getParent());//BootstrapClassLoader（null）
        System.out.println( System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        System.out.println(File.separator);
    }
    }
