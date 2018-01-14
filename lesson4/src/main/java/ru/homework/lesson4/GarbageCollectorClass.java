package ru.homework.lesson4;

import java.lang.management.GarbageCollectorMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhmv on 13.01.2018.
 */
public class GarbageCollectorClass {

    private List<GarbageCollectorMXBean> garbageCollectorList;
    private Map<String, String> map = new HashMap<>();
    private GarbageCollectorMXBean oldGC;
    private GarbageCollectorMXBean youngGC;

    GarbageCollectorClass(List<GarbageCollectorMXBean> gcList)
    {
        garbageCollectorList = gcList;
        //youngGC
        map.put("Copy", "Young");
        map.put("PS Scavenge", "Young");
        map.put("ParNew", "Young");
        map.put("G1 Young Generation", "Young");
        //oldGC
        map.put("MarkSweepCompact", "Old");
        map.put("PS MarkSweep", "Old");
        map.put("ConcurrentMarkSweep", "Old");
        map.put("G1 Mixed Generation", "Old");
        map.put("G1 Old Generation", "Old");

        for (GarbageCollectorMXBean gc : gcList) {
            String name = gc.getName();
            String type = map.get(name);
            if("Young".equals(type)){
                youngGC = gc;
            }
            if("Old".equals(type)){
                oldGC = gc;
            }
        }
    }

    public GarbageCollectorMXBean getOldGC() {
        return oldGC;
    }

    public GarbageCollectorMXBean getYoungGC() {
        return youngGC;
    }

    long getOldCount() {
        return oldGC.getCollectionCount();
    }

    long getYuongCount() {
        return youngGC.getCollectionCount();
    }

    long getOldTime() {
        return oldGC.getCollectionTime();
    }

    long getYuongTime() {
        return youngGC.getCollectionTime();
    }
    String getOldName() {
        return oldGC.getName();
    }

    String  getYuongName() {
        return youngGC.getName();
    }

}