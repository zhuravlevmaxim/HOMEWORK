package ru.homework.lesson2;

import java.lang.instrument.Instrumentation;

/**
 * Created by zhmv on 03.01.2018.
 */
public class AgentGetMemorySize {

    private static Instrumentation instrumentation;

    private static final String INIT_AGENT = "init agent";
    private static final String NOT_INIT_AGENT = "not init agent";

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println(INIT_AGENT);
        AgentGetMemorySize.instrumentation = instrumentation;
    }

    public static long getSizeObject(Object obj) {
        if (instrumentation == null) {
            throw new IllegalStateException(NOT_INIT_AGENT);
        }
        return instrumentation.getObjectSize(obj);
    }

}
