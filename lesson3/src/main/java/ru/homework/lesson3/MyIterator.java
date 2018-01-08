package ru.homework.lesson3;

import java.util.Iterator;

/**
 * Created by zhmv on 07.01.2018.
 */
public class MyIterator<E> implements Iterator<E> {

    private E [] objects;
    private int size;
    private int index = 0;

    public MyIterator(E [] objects, int size)
    {
        this.objects = objects;
        this.size = size;
    }

    public boolean hasNext() {
        return index < size;
    }

    public E next() {
        return objects[index++];
    }
}
