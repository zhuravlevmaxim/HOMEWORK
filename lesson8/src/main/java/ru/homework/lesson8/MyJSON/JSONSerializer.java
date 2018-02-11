package ru.homework.lesson8.MyJSON;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by zhmv on 26.01.2018.
 */
public class JSONSerializer {

    public static String objectToJSON(Object object){
        StringBuilder result = new StringBuilder();
        Class<?> classObj = object.getClass();
        result.append(classObj.getName());
        result.append("{");
        //result.append("\n");
        Field [] fields = classObj.getFields();
        int sizeMas = fields.length;
        int count = 0;
        for(Field field : fields)
        {
            result.append("\"" + field.getName() + "\": ");
            try {
                result.append(valueToJSON(field.get(object)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            count++;
            if(count < sizeMas) {
                result.append(",");
            }
                //result.append("\n");
        }
        result.append("}");
        return result.toString();
    }

    private static String valueToJSON(Object object)
    {
        if(object == null || object instanceof Number || object instanceof Boolean || object instanceof Character)
        {
           return String.valueOf(object);
        }

        if(object instanceof String)
        {
            return "\""+object+"\"";
        }

        if(object.getClass().isArray())
        {
            StringBuilder strArr = new StringBuilder();
            //strArr.append("\n");
            strArr.append("[");
            int size = Array.getLength(object);
            for(int i = 0;i < size;) {
                strArr.append(valueToJSON(Array.get(object, i)));
                i++;
                if (i < size) {
                    strArr.append(",");
                }
            }
            //strArr.append("\n");
            strArr.append("]");
            return strArr.toString();
        }

        if(object instanceof Collection)
        {
            StringBuilder strCol = new StringBuilder("[");
            strCol.append("\n");
            Collection collection = (Collection)object;
            int size = collection.size();
            int count = 0;
            for(Object o : collection)
            {
                strCol.append(valueToJSON(o));
                count++;
                if(count < size) {
                    strCol.append(",");
                }
            }
            //strCol.append("\n");
            strCol.append("]");
            return strCol.toString();
        }
        return objectToJSON(object);
    }
}
