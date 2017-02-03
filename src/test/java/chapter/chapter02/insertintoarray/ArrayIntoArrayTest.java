package chapter.chapter02.insertintoarray;

import static org.junit.Assert.*;

import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/2/3.
 */
public class ArrayIntoArrayTest extends TestSupport {

  @Test
  public void insertAndSort() throws Exception {
     Integer[] a1 = new Integer[]{2,11,13,25,46,null,null,null,null,null,null};
     Integer[] a2 = new Integer[]{8,11,32,43};
    logger.info(toJson(ArrayIntoArray.insertAndSort(a1,a2,5)));
  }
  @Test
  public void insertAndSort2() throws Exception {
    Integer[] a1 = new Integer[]{11,12,13,25,46,null,null,null,null,null,null};
    Integer[] a2 = new Integer[]{8,10,32,43};
    logger.info(toJson(ArrayIntoArray.insertAndSort(a1,a2,5)));
  }
}