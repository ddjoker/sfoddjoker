package chapter.chapter01;

import java.util.LinkedList;

/**
 *
 * 获取链表中倒数K位的值
 *
 * 关键是注意各种的异常情况
 * Created by dong on 2016/12/7.
 */
public class LinksLastKValue {

    public static String value(LinkedList<String> stringLinkedList, int k) {
        if (stringLinkedList == null)
            return null;
        if (stringLinkedList.size() <= k)
            return null;
        if (k < 0)
            return null;

        return stringLinkedList.get(stringLinkedList.size()-k-1);
    }

}
