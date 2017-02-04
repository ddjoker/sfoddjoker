package chapter.chapter01;

import model.link.DoublyLinkModel;

/**
 * 求链表的倒数第K个节点
 * Created by dong on 2016/12/7.
 */
public class LinkModelLastKValue {

  public static <T> T value(DoublyLinkModel<T> linkHead, int k) {
    if (linkHead == null) {
      return null;
    }
    DoublyLinkModel<T> latterModel = null;

    DoublyLinkModel<T> tempLinkHead = linkHead;

    for (int i = 0, j = 0; tempLinkHead.getLatter() != null; i++) {

      tempLinkHead = tempLinkHead.getLatter();

      if (i == k) {
        latterModel = linkHead;
      }
      if (i >= k) {
        latterModel = latterModel.getLatter();
        j++;
      }
    }

    if (latterModel != null) {
      return latterModel.getValue();
    }
    return null;
  }
}
