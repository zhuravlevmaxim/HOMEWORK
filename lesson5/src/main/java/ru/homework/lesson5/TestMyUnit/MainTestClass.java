package ru.homework.lesson5.TestMyUnit;

import ru.homework.lesson5.MyUnit.TestRunner;

/**
 * Created by zhmv on 19.01.2018.
 */
public class MainTestClass {

    public static void main(String[] args) throws Exception {

        TestRunner.runFromClass("ru.homework.lesson5.TestMyUnit.Tests.Test1.class");

        TestRunner.runFromPackage("ru.homework.lesson5.TestMyUnit.Tests");

    }
}
