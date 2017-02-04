package chapter.chapter02.linkmodel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import json.JsonBuilder;
import model.link.SinglyLinkModel;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/2/4.
 */
public class SinglyLinkListTest extends TestSupport {

  @Test
  public void inversionPrint() throws Exception {
    SinglyLinkList<String> list = new SinglyLinkList<String>();
    for (int i = 0; i < 10; i++) {
      list.add("model "+i);
    }
    ArrayList<String> valueList = list.list();
    for (int i = valueList.size() - 1; i >= 0; i--) {
      logger.info(valueList.get(i));
    }
  }

  @Test
  public void add() throws Exception {
    SinglyLinkList<String> list = new SinglyLinkList<String>();
    for (int i = 0; i < 10; i++) {
      list.add("model "+i);
    }
    logger.info(toJson(list.getHead()));
  }

  @Test
  public void findAt() throws Exception {
    SinglyLinkList<String> list = new SinglyLinkList<String>();
    for (int i = 0; i < 10; i++) {
      list.add("model "+i);
    }
    logger.info(toJson(list.getHead()));

    logger.info(toJson(list.findAt(5)));
  }

  @Test
  public void remove() throws Exception {
    SinglyLinkList<String> list = new SinglyLinkList<String>();
    for (int i = 0; i < 10; i++) {
      list.add("model "+i);
    }
    logger.info(toJson(list.getHead()));
    list.remove(5);
    logger.info(toJson(list.getHead()));
  }
  @Test
  public void print() throws Exception {
    SinglyLinkList<String> list = new SinglyLinkList<String>();
    for (int i = 0; i < 10; i++) {
      list.add("model "+i);
    }
    printLinkListDesc(list.getHead());
  }
  //会产生调用栈溢出.不推荐
  public <T> void printLinkListDesc(SinglyLinkModel<T> singlyLinkModel){
    if(singlyLinkModel!=null &&singlyLinkModel.getNext()!=null){
      printLinkListDesc(singlyLinkModel.getNext());
    }
    logger.info(JsonBuilder.toJson(singlyLinkModel.getValue()));
  }

}