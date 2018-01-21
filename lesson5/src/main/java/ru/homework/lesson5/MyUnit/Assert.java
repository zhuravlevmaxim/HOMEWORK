package ru.homework.lesson5.MyUnit;

import java.util.Objects;

/**
 * Created by zhmv on 18.01.2018.
 */
public class Assert {

    public static void assertTrue(Object obj1, Object obj2) {
        if (!Objects.equals(obj1, obj2)) {
            throw new AssertException(obj1 + " not equals with " + obj2);
        }
    }
}
