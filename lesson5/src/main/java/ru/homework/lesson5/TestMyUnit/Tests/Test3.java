package ru.homework.lesson5.TestMyUnit.Tests;

import ru.homework.lesson5.MyUnit.Annotation.Test;
import ru.homework.lesson5.MyUnit.Assert;

/**
 * Created by zhmv on 21.01.2018.
 */
public class Test3 {

    @Test
    public void test1()
    {
        System.out.println("test1 class: Test3");
        try{
            Assert.assertTrue("zxc", "vbn");
        }finally {
            System.out.println("Test failed!");
        }
        System.out.println("Test success");
    }

    @Test
    public void test2()
    {
        System.out.println("test2 class: Test3");
        try{
            Assert.assertTrue("zxc", "zxc");
        }finally {
            System.out.println("Test failed!");
        }
        System.out.println("Test success");
    }
}
