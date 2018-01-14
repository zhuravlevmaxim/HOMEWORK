package ru.homework.lesson4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhmv on 14.01.2018.
 */
public class DaemonThreadClass extends Thread {

    private GarbageCollectorClass gcBean;

    private long oldCount = 0;
    private long youngCount = 0;
    private long oldTime = 0;
    private long youngTime = 0;
    private final int periodSeconds = 5;
    private AtomicLong atomicLong;

    public DaemonThreadClass(GarbageCollectorClass collectorClass, AtomicLong along)
    {
        gcBean = collectorClass;
        atomicLong = along;
        this.setDaemon(true);
    }

    @Override
    public void run()
    {
        System.out.println("Garbage Collection test.");
        System.out.println("young: "+gcBean.getYoungGC().getName() );
        System.out.println("  old: " + gcBean.getOldGC().getName());
        System.out.println("probe period "+periodSeconds+" sec.");
        System.out.println("__iter_  __________young________ __________old__________  gc util");
        System.out.println("_count_  ___count___ __time_ms__ ___count___ __time_ms__  __%%__");
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(periodSeconds);
                long oc = gcBean.getOldCount();
                long yc = gcBean.getYuongCount();
                long ot = gcBean.getOldTime();
                long yt = gcBean.getYuongTime();
                double t = ((yt - youngTime) + (ot - oldTime))/1000.0*100.0 / periodSeconds;
                System.out.printf("%7s  %11s %11s %11s %11s  %.3f\n",
                        atomicLong.get(), yc - youngCount, yt - youngTime,
                        oc - oldCount, ot - oldTime,t);
                youngCount = yc;
                youngTime = yt;
                oldCount = oc;
                oldTime = ot;
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
}
