package ru.homework.lesson3;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by zhmv on 07.01.2018.
 */
public class MyHWTest {

    @Test
    public void addAllTest()
    {
        List<String> l1 = Arrays.asList("a", "b", "c");
        MyArrayList ml = new MyArrayList();
        ml.addAll(l1);
        Assert.assertTrue(ml.contains("a"));
        Assert.assertTrue(ml.contains("b"));
        Assert.assertTrue(ml.contains("c"));
    }

    @Test
    public void copyTest()
    {
        List<String> l1 = Arrays.asList("aa", "bb", "cc", "dd");
        MyArrayList<String> ml = new MyArrayList<>();
        Collections.addAll(ml, "aaa", "bbb", "ccc", "ddd");
        Collections.copy(ml,l1);
        Assert.assertTrue(ml.contains("aa"));
        Assert.assertTrue(ml.contains("bb"));
        Assert.assertTrue(ml.contains("cc"));
        Assert.assertTrue(ml.contains("dd"));
    }

    @Test
    public void sortTest()
    {
        MyArrayList<String> ml = new MyArrayList<>();
        Collections.addAll(ml, "F", "B", "C", "D", "E", "A");
        Collections.sort(ml, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Assert.assertTrue(ml.indexOf("A") == 0);
        Assert.assertTrue(ml.indexOf("B") == 1);
        Assert.assertTrue(ml.indexOf("C") == 2);
    }
}
