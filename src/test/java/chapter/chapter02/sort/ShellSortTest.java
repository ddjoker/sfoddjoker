package chapter.chapter02.sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/10.
 */
public class ShellSortTest extends TestSupport {

  private int[] array = null;
  @Before
  public void setUp() {
    array = new int[]{3,123,2,4,5,1,532,7};
  }

  @Test
  public void sort() throws Exception {
    ShellSort.sort(array);
    logger.info(toJson(array));
  }

}