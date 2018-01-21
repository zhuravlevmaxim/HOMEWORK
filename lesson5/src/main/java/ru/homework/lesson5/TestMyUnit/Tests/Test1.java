package ru.homework.lesson5.TestMyUnit.Tests;

import ru.homework.lesson5.MyUnit.Annotation.After;
import ru.homework.lesson5.MyUnit.Annotation.Before;
import ru.homework.lesson5.MyUnit.Annotation.Test;

/**
 * Created by zhmv on 19.01.2018.
 */
public class Test1 {

    @Before
    public void beforeTest1()
    {
        System.out.println("before class: Test1");
    }

    @Test
    public static void test1()
    {
        System.out.println("test1 class: Test1");
    }

    @Test
    public void test2()
    {
        System.out.println("test2 class: Test1");
    }

    @Test
    public void test3()
    {
        System.out.println("test3 class: Test1");
    }

    @After
    public void afterTest1()
    {
        System.out.println("after class: Test1");
    }

}
