package chapter.chapter01;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by dong on 2016/12/5.
 */
@RunWith(Parameterized.class)
public class String2IntTest {

    private String expected;

    private int target;

    public String2IntTest(String expected, int target) {
        this.expected = expected;
        this.target = target;
    }

    @Parameterized.Parameters
    public static Collection checkers() {
        return Arrays.asList(new Object[][]{
                {"1234123124", 1234123124},
                {"1234123124", 1234123124},
                {"1231ad", 0},
                {"" + Integer.MIN_VALUE, Integer.MIN_VALUE},
                {"" + Integer.MAX_VALUE, Integer.MAX_VALUE},
                {"1" + Integer.MAX_VALUE, 0},
                {"123.123", 0},
        });
    }

    @org.junit.Test
    public void string2Int() throws Exception {
        Assert.assertEquals(target, String2Int.string2Int(expected));
    }

}