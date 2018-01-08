package ru.homework.lesson3;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by zhmv on 06.01.2018.
 */
public class MyArrayList<E> implements List<E> {

    private Object [] objects = new Object[50];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public Iterator<E> iterator() {
        return new MyIterator<E>((E[])objects, size);
    }

    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    public <T> T[] toArray(T[] a) {
        throw new NotImplementedException();
    }

    public boolean add(E e) {
        if(size == objects.length)
        {
            objects = Arrays.copyOf(objects, objects.length);
        }
        objects[size] = e;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1)
        {
            return false;
        }
        remove(index);
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for(Object o : c)
        {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        c.forEach(element -> add(element));
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for(Object o : c)
        {
            result = result | remove(o);
        }
        return result;
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        size = 0;
    }

    public E get(int index) {
        if(index >= 0 && index < size) {
            return (E) objects[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public E set(int index, E element) {
        if(index >= 0 && index < size)
        {
            E result = (E)objects[index];
            objects[index] = element;
            return result;
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        E result = get(index);
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
        --size;
        return result;
    }

    public int indexOf(Object o) {

        for(int i = 0; i < size; i++)
        {
            if(Objects.equals(o,objects[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--)
        {
            if(Objects.equals(o, objects[i]));
            {
                return i;
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new MyListIterator<E>((E[])objects, size);
    }

    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
