package ru.homework.lesson3;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ListIterator;

/**
 * Created by zhmv 07.01.2018.
 */
public class MyListIterator<E> implements ListIterator<E> {

    private E[] objects;
    private int size;
    private int index = 0;

    public MyListIterator(E[] objects, int size)
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

    public boolean hasPrevious() {
        return index > 0;
    }

    public E previous() {
        return objects[--index];
    }

    public int nextIndex() {
        return index;
    }

    public int previousIndex() {
        return index - 1;
    }

    public void remove() {
        throw new NotImplementedException();
    }

    public void set(E e) {
        objects[index - 1] = e;
    }

    public void add(E e) {
        throw new NotImplementedException();
    }
}
