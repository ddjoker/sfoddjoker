package chapter.chapter02.insertintoarray;

/**
 * <p>有两个排序的数组A1和A2,内存在A1的末尾有足够多的空余空间.
 * 实现一个函数将A2插入A1中并排序</p>
 *
 * Created by dong on 2017/2/3.
 */
public class ArrayIntoArray {


  /**
   * Insert and sort int [ ].
   * 1. a1 a2 两个都不可为空
   * 2. 长度已知  且 a1 可扩展,可得出最大长度,那么就可以根据比较最大值的方式得出最后一位和第一位
   * 3. 数组均为排序的,
   *
   * @param a1 the a 1
   * @param a2 the a 2
   * @return the int [ ]
   */
  public static Integer[] insertAndSort(Integer[] a1, Integer[] a2, int validateLength) {
    if (a1 == null) {
      return a2;
    }
    if (a2 == null) {
      return a1;
    }
    if (validateLength == 0) {
      return a2;
    }

    int maxlength = a2.length + validateLength;

    int i = validateLength - 1;
    int y = a2.length - 1;
    int z = maxlength - 1;
    while (z >= 0) {
      if (i < 0 || y < 0) {
        if (i < 0) {
          a1[z--] = a2[y--];
        }
        if (y < 0) {
          z = -1;
        }
      } else {
        if (a1[i] > a2[y]) {
          a1[z--] = a1[i--];
          a1[z] = a2[y];
        } else {
          a1[z--] = a2[y--];
          a1[z] = a1[i];
        }
      }

    }
    return a1;
  }
}
