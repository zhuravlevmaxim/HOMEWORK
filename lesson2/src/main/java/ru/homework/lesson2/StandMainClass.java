package ru.homework.lesson2;

import java.util.*;

/**
 * Created by zhmv on 03.01.2018.
 */
public class StandMainClass {

    public static void main(String[] args) {
        List<Integer> c1000 = Collections.nCopies(1000, new Integer(1000));
        List<Integer> c1000000 = Collections.nCopies(1000000, new Integer(1000));
        printObjectSize(new Object());
        printObjectSize(new Integer(2001));
        printObjectSize(new Long(2001));
        printObjectSize("");
        printObjectSize(new ArrayList());
        printObjectSize(new ArrayList(c1000));
        printObjectSize(new ArrayList(c1000000));
        printObjectSize(new LinkedList());
        printObjectSize(new LinkedList(c1000));

        //переполнение стека
        //printObjectSize(new LinkedList(c1000000));
    }

    public static void printObjectSize(Object obj) {
        System.out.println(String.format("%s, size = %s", obj.getClass().getSimpleName(), GetSizeClass.sizeOf(obj)));
    }
}
