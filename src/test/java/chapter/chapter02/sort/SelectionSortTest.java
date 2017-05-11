package chapter.chapter02.sort;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/11.
 */
public class SelectionSortTest extends TestSupport {
  private int[] data;

  @Before
  public void setUp() throws Exception {
    data = new int[]{
        2, 3, 6, 8, 10, 12, 22, 5, 1, 7, 32, 51, 322, 66, 3, 42, 31, 54, 12, 3523, 26,
        623
    };

  }
  @Test
  public void sort() throws Exception {
    SelectionSort.sort(data);
    logger.info(toJson(data));
  }

}