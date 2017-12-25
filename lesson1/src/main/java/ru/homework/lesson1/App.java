package ru.homework.lesson1;

import com.google.common.base.Joiner;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{

    private static Scanner sc = new Scanner(System.in);
    private static MainWorkerClass mainWorkerClass = new MainWorkerClass(sc);


    public static void main( String[] args ) {
        mainWorkerClass.mainMethod();
    }
}