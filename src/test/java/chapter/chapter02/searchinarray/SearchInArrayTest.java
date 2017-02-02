package chapter.chapter02.searchinarray;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.TestSupport;

/**
 * Created by dong on 2017/2/1.
 */
@RunWith(Parameterized.class)
public class SearchInArrayTest extends TestSupport {

  private boolean result;

  private int target;

  /**
   * Instantiates a new Search in array test.
   *
   * @param result the result
   * @param target the target
   */
  public SearchInArrayTest(boolean result, int target) {
    this.result = result;
    this.target = target;
  }

  private int[][] array = new int[][]{
      {1, 3, 5, 6, 9},
      {2, 5, 6, 7, 10},
      {5, 9, 13, 15, 23},
      {6, 12, 15, 25, 29}
  };

  /**
   * Checkers collection.
   * 测试用例
   * <P>
   * 存在的数字
   * <ul>
   * <li>最小值</li>
   * <li>最大值</li>
   * <li>中间的值</li>
   * </ul>
   * </P>
   * <p>
   * 无此数字
   * <ul>
   * <li>超过最大值</li>
   * <li>小于最小值</li>
   * <li>无此数字</li>
   * </ul>
   * </p>
   * <P>
   * 特殊测试
   * <UL>
   * <LI>空指针</LI>
   * </UL>
   * </P>
   *
   * @return the collection
   */
  @Parameterized.Parameters
  public static Collection checkers() {
    return Arrays.asList(new Object[][]{
        {true, 1},
        {true, 29},
        {true, 13},
        {false, -1},
        {false, 30},
        {false, 14}
    });
  }

  /**
   * Is exists.
   *
   * @throws Exception the exception
   */
  @Test
  public void isExists() throws Exception {
    Assert.assertEquals(result,SearchInArray.isExists(array,target));

  }

}