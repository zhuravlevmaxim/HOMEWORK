package ru.homework.lesson5.MyUnit;

import ru.homework.lesson5.MyUnit.Annotation.After;
import ru.homework.lesson5.MyUnit.Annotation.Before;
import ru.homework.lesson5.MyUnit.Annotation.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Created by zhmv on 18.01.2018.
 */
public class TestRunner {

    public static void runFromClass(String file) {

        if(file.endsWith(".class")) {
            file = file.replace(".class", "");
        }
        try {
            Class<?> classTest = Thread.currentThread().getContextClassLoader().loadClass(file);
            runTest(classTest);
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void runFromPackage(String packagePath) {
        String path = System.getProperty("java.class.path", ".");
        String pathSeparator = System.getProperty("path.separator");
        String [] pathStringMas = path.split(pathSeparator);
        List<String> filesPath = new ArrayList<>();
        String pack ="";
        for(String s : pathStringMas) {
            File fileClassPath = new File(s);
            if(fileClassPath.isDirectory()) {
                filesPath.addAll(getFilesFormDirectory(fileClassPath, pack));
            }
            else{
                filesPath.addAll(getFilesFromJar(fileClassPath));
            }
        }

        filesPath.stream().map(element -> element.replace("\\", ".")).
                filter(element -> element.contains(packagePath)).
                forEach(file -> TestRunner.runFromClass(file));
    }

    private static List<String> getFilesFormDirectory(File file, String pack)
    {
        ArrayList<String> list = new ArrayList<>();
        for(File f : file.listFiles())
        {
            if(f.isDirectory())
            {
                String newPack = pack.equals("") ? f.getName() : pack+"."+f.getName();
                list.addAll(getFilesFormDirectory(f, newPack));
            }
            else {
                list.add(pack + "." + f.getName());
            }
        }
        return list;
    }

    private static List<String> getFilesFromJar(File file) {
        List<String> list = new ArrayList<>();
        try (
                ZipFile zf = new ZipFile(file)
        ) {
            Enumeration entries = zf.entries();
            while (entries.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) entries.nextElement();
                String fileName = ze.getName().replace("/",".");
                if(fileName.endsWith(".class")) {
                    list.add(fileName);
                }
            }
        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    private static void runTest(Class<?> classTest) {
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Method> testMethods = new ArrayList<>();
        Method[] methods = classTest.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Before.class) != null) {
                beforeMethod = method;
                continue;
            }
            if (method.getAnnotation(After.class) != null) {
                afterMethod = method;
                continue;
            }
            if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
                continue;
            }
        }
        try {
            Object obj = classTest.newInstance();
            if (beforeMethod != null) {
                beforeMethod.invoke(obj);
            }
            for (Method method : testMethods) {
                try {
                    method.invoke(obj);
                }catch (InvocationTargetException e)
                {
                    System.out.println("failed: "+method.getName());
                }
            }
            if (afterMethod != null) {
                afterMethod.invoke(obj);
            }
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }
    }
}
