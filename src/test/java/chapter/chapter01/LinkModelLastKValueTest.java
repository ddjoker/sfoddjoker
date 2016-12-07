package chapter.chapter01;

import model.link.LinkModel;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 求链表的倒数第K个节点
 * Created by dong on 2016/12/7.
 */
public class LinkModelLastKValueTest {
    private static LinkModel<Integer> linkHead = null;


    @Test
    public void value(){
       Assert.assertEquals(7, LinkModelLastKValue.value(linkHead,3).intValue());

        Assert.assertEquals(10, LinkModelLastKValue.value(linkHead,0).intValue());

        Assert.assertEquals(null, LinkModelLastKValue.value(linkHead,11));
        Assert.assertEquals(null, LinkModelLastKValue.value(null,3));
    }

    @BeforeClass
    public static void init() {
        linkHead = new LinkModel<Integer>(0);
        LinkModel<Integer> temp = linkHead;
        for (int i = 1; i <= 10; i++) {
            temp.setLatter(new LinkModel<Integer>(i));
            temp = temp.getLatter();
        }
    }

    @AfterClass
    public static void destory() {
        linkHead = null;
    }

}