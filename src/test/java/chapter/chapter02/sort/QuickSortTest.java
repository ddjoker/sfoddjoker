package chapter.chapter02.sort;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/8.
 */
public class QuickSortTest extends TestSupport {

  private Integer[] data;

  @Before
  public void setUp() throws Exception {
    List<Integer> list = Lists
        .newArrayList(2, 3, 6, 8, 10, 12, 22, 5, 1, 7, 32, 51, 322, 66, 3, 42, 31, 54, 12, 3523, 26,
            623);
    data = new Integer[list.size()];

    data = list.toArray(data);
  }

  @Test
  public void sort() throws Exception {
    QuickSort quickSort = new QuickSort();
    quickSort.sort(data, data.length, 0, data.length - 1);
    logger.info(toJson(data));
  }

}