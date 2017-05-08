package chapter.chapter02.search;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/8.
 */
public class BinarySearchTest extends TestSupport {

  private List<Integer> sortedList;
  @Before
  public void beforeClass(){
    sortedList = Lists.newArrayList(1,2,3,5,6,8,9,10,12,14,15,18);
  }
  @Test
  public void search() throws Exception {
    logger.info(toJson(BinarySearch.search(sortedList, 11)));
  }

}