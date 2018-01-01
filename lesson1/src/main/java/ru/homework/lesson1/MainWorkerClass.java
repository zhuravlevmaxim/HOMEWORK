package ru.homework.lesson1;

import com.google.common.base.Strings;

import java.util.Scanner;

/**
 * Created by zhmv on 25.12.2017.
 */
public class MainWorkerClass {

    private static Scanner sc;

    public MainWorkerClass(Scanner scanner)
    {
        sc = scanner;
    }

    public static void mainMethod()
    {
        while(true)
        {
            printInConsole(DataClass.WRITE_TEXT + "\n" + DataClass.EXIT_TEXT);
            String tmp = sc.nextLine();
            if(tmp.equalsIgnoreCase("exit"))
            {
                break;
            }
            if(Strings.isNullOrEmpty(tmp))
            {
                printInConsole(DataClass.EMPTY_TEXT);
            }
            printInConsole(tmp.toUpperCase());
        }
        printInConsole(DataClass.FINISH_TEXT);
    }

    private static void printInConsole(String text)
    {
        System.out.println(text);
    }
}
