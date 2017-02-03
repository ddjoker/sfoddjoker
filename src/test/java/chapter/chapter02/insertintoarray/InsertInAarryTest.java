package chapter.chapter02.insertintoarray;

import static org.junit.Assert.*;

import json.JsonBuilder;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/2/3.
 */
public class InsertInAarryTest extends TestSupport {

  @Test
  public void replaceChar() throws Exception {
    logger.info(JsonBuilder.toJson(InsertInAarry.replaceChar(chars,new char[]{'%','2','0'})));
  }

  private char[] chars = new char[]{'W','e', ' ','a','r','e',' ','s','o',' ','h','a','p','p','y','.'};

}