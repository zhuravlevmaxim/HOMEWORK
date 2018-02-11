package ru.homework.lesson8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.homework.lesson8.MyJSON.JSONSerializer;
import ru.homework.lesson8.MyJSON.MyClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhmv on 28.01.2018.
 */
public class MyJSONTest {

    private MyClass myClass;

    @Before
    public void init()
    {
        myClass = new MyClass();
    }
    @Test
    public void testPrimitive()
    {
        myClass.pLong = 3141444214L;
        myClass.pInteger = 10;
        myClass.pDouble = 5.02523;
        myClass.pFloat = 3.452f;
        myClass.pChar = 's';
        myClass.pShort = 253;
        myClass.pByte = 25;
        myClass.pBoolean = true;
        String jsonMyObject = "\"pLong\": 3141444214,\"pInteger\": 10," +
                "\"pDouble\": 5.02523,\"pFloat\": 3.452,\"pChar\": s," +
                "\"pShort\": 253,\"pByte\": 25,\"pBoolean\": true";
        Assert.assertTrue(JSONSerializer.objectToJSON(myClass).contains(jsonMyObject));

    }
    @Test
    public void testObject()
    {
        myClass.pMyClass = new MyClass();
        myClass.pMyClass.pChar = 'F';
        myClass.pMyClass.pFloat = 12.56f;
        String jsonMyObject = "\"pFloat\": 12.56,\"pChar\": F";
        Assert.assertTrue(JSONSerializer.objectToJSON(myClass).contains(jsonMyObject));
    }
    @Test
    public void testArray()
    {
        myClass.pMyClass = new MyClass();
        myClass.intMas = new int[]{1,2,3,4,5,6};
        String jsonMyObject = "\"intMas\": [1,2,3,4,5,6]";
        Assert.assertTrue(JSONSerializer.objectToJSON(myClass).contains(jsonMyObject));
    }
    @Test
    public void testCollection()
    {
        myClass.pMyClass = new MyClass();
        List<String> listString = new ArrayList<String>();
        listString.addAll(Arrays.asList(new String[]{"String1","String2","String3"}));
        myClass.pList = listString;
        String jsonMyObject = "\"String1\",\"String2\",\"String3\"";

        System.out.println(JSONSerializer.objectToJSON(myClass));

        Assert.assertTrue(JSONSerializer.objectToJSON(myClass).contains(jsonMyObject));
    }
    @After
    public void destroy()
    {
        myClass = null;
    }
}
