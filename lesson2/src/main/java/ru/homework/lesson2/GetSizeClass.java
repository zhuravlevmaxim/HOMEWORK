package ru.homework.lesson2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class GetSizeClass
{
    private static Set<Object> objectsSet;

    public static long sizeOf(Object obj)
    {
        long sizeObject = 0;
        objectsSet = new HashSet<Object>();
        sizeObject = AgentGetMemorySize.getSizeObject(obj);
        getChildObjects(obj);
        for(Object o : objectsSet)
        {
            sizeObject += AgentGetMemorySize.getSizeObject(o);
        }
        return sizeObject;
    }


    private static void getChildObjects(Object obj) {

        if(obj == null) {
            return;
        }
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive()) {
                    continue;
                }
                field.setAccessible(true);
                try {
                    Object o = field.get(obj);
                    if(o != null && !objectsSet.contains(o)) {
                        objectsSet.add(o);
                        getChildObjects(o);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
    }
}
