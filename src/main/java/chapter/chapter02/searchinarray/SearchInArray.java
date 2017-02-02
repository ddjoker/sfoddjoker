package chapter.chapter02.searchinarray;

/**
 * 二维数组中的查找
 * <p>
 * 在一个二维数组中,每一行都是按照从左到右递增的顺序排序,每一列都是从上到下递增的顺序排序.请完成一个函数,输入这样的一个二维数组和一个整数,判断数组中是否包含此整数.
 * <p>
 * 考察应聘者对二维数组的理解和编程能力.二维数组在内存中占据了连续的空间.
 * 在内存中从上到下存储各行元素,在同一行中从左到右的顺序存储.根据行号和列号来计算出对应偏移量.
 * 从而找到对应元素.
 * </p>
 * <P>
 * 考察应聘者分析问题的能力.当应聘者发现问题比较复杂时,能不能通过具体的例子找出其中的规律
 * </P>
 * Created by dong on 2016/12/10.
 */
public class SearchInArray {

  /**
   * Is exists boolean.
   *
   * @param array the array
   * @param value the value
   * @return the boolean
   */
  public static boolean isExists(int[][] array, int value) {
    boolean isExists = false;

    //数组为空时,处理结束,表示为无法找到
    if (array == null) {
      return false;
    }

    //数字小于第一位,表示为无法找到
    if (value < array[0][0]) {
      return false;
    }


    int row = array.length;

    if (array[row - 1] == null) {
      return false;
    }

    int col = array[row - 1].length;

    if (value > array[row - 1][col - 1]) {
      return false;
    }

    if (value == array[0][0]) {
      return true;
    }

    if (value == array[row - 1][col - 1]) {
      return true;
    }

    int startx = 0, starty = 0;
    while (startx < col & starty < row) {
      if (array[row - 1][startx] < value) {
        startx++;
        continue;
      }

      while (starty < row) {
        if (array[starty][col - 1] < value) {
          starty++;
          continue;
        }
        for (int tempy = starty; tempy < row; tempy++) {
          if (array[tempy][startx] == value) {
            return true;
          }
        }
        starty++;
      }
    }

    return false;
  }
}
