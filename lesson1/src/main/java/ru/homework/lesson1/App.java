package ru.homework.lesson1;

import java.util.Scanner;

public class App
{

    private static Scanner sc = new Scanner(System.in);
    private static MainWorkerClass mainWorkerClass = new MainWorkerClass(sc);


    public static void main( String[] args ) {
        mainWorkerClass.mainMethod();
    }
}