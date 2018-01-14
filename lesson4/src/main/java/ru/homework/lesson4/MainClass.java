package ru.homework.lesson4;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/**
 * Created by zhmv on 13.01.2018.
 */
public class MainClass {

    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String[] args) {
        startTime = new Date().getTime();

        List<GarbageCollectorMXBean> gcList = ManagementFactory.getGarbageCollectorMXBeans();
        GarbageCollectorClass gcBean = new GarbageCollectorClass(gcList);
        List<Object> list = new ArrayList();
        AtomicLong atomicLong = new AtomicLong();

        try {
            DaemonThreadClass daemonThreadClass = new DaemonThreadClass(gcBean, atomicLong);
            daemonThreadClass.start();

            while (true) {
                addElementInList(list, () -> new long[1000], 1000);
                dellElements(list, 900);
                atomicLong.incrementAndGet();
            }
        } finally {
            endTime = new Date().getTime();
            System.out.printf("Program worked %.3f  seconds.\n",((endTime - startTime)/1000.0));
        }
    }

    private static void addElementInList(List<Object> list, Supplier<Object> supplier, int countElementAdd)
    {
        for(int i = 0; i < countElementAdd; i++)
        {
            list.add(supplier.get());
        }
    }
    private static void dellElements(List<Object> list, int countElementsDel)
    {
        for(int i = 0; i < countElementsDel; i++)
        {
            list.remove(0);
        }
    }
}
