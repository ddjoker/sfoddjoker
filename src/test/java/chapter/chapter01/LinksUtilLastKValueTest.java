package chapter.chapter01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by dong on 2016/12/7.
 */
@RunWith(Parameterized.class)
public class LinksUtilLastKValueTest {
    private int iSeat;
    private String value;

    public LinksUtilLastKValueTest(int iSeat, String value) {
        this.iSeat = iSeat;
        this.value = value;
    }

    private static LinkedList<String> linkedList = null;

    @Test
    public void stringLinkedList() {
        Assert.assertEquals(value, LinksUtilLastKValue.value(linkedList, iSeat));
    }

    @Test
    public void stringLinkedListNull() {
        Assert.assertEquals(null, LinksUtilLastKValue.value(null, iSeat));
    }


    @Parameterized.Parameters
    public static Collection checkers() {
        return Arrays.asList(new Object[][]{
                {5, "Test4"},
                {-1, null},
                {10, null},
        });
    }


    @BeforeClass
    public static void init() {
        linkedList = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            linkedList.add("Test" + i);
        }
    }

    @AfterClass
    public static void destory() {
        linkedList = null;
    }
}