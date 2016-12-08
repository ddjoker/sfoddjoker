package chapter.chapter01.algorithm;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by dong on 2016/12/9.
 */
@RunWith(Parameterized.class)
public class BinarySearchTest {
    @Test
    public void search() throws Exception {
        Assert.assertEquals(target,BinarySearch.search(array,expected, BinarySearch.ArrayOrder.ASC));
    }

    private int expected;

    private int target;

    public BinarySearchTest(int expected, int target) {
        this.expected = expected;
        this.target = target;
    }

    @Parameterized.Parameters
    public static Collection checkers() {
        return Arrays.asList(new Object[][]{
                {3,0},
                {20*10+3, 20},
                {99*10+3, 99},
                { Integer.MIN_VALUE, -1},
                { Integer.MAX_VALUE, -1},

        });
    }


    private static Integer[] array = null;

    @BeforeClass
    public static void init() {
        array = new Integer[100];
        for (int i = 0; i <100; i++) {
            array[i] = i*10+3;
        }
    }

    @AfterClass
    public static void destory() {
        array = null;
    }

}