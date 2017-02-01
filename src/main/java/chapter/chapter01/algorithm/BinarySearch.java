package chapter.chapter01.algorithm;

/**
 * Created by dong on 2016/12/8.
 */
public class BinarySearch {

  public enum ArrayOrder {
    ASC, DESC
  }

  /**
   * @param array 有序的数组
   * @param target 指定数字
   */
  public static int search(Integer[] array, int target, ArrayOrder order) {
    if (array == null || array.length == 0) {
      return -1;
    }

    if (target == array[array.length - 1]) {
      return array.length - 1;
    }
    if (target == array[0]) {
      return 0;
    }

    if (order == ArrayOrder.ASC) {
      if ((target > array[array.length - 1]) || (target < array[0])) {
        return -1;
      }
    } else {
      if ((target < array[array.length - 1]) || (target > array[0])) {
        return -1;
      }
    }

    int begin = 0;
    int end = array.length;
    int index = 0;
    while ((index = (begin + end) / 2) > 0) {
      if (array[index] == target) {
        break;
      }
      if (index == 0) {
        return -1;
      }
      if (array[index] > target) {
        if (order == ArrayOrder.ASC) {
          end = index;
        } else {
          begin = index;
        }
      } else {
        if (order == ArrayOrder.ASC) {
          begin = index;
        } else {
          end = index;
        }
      }
    }
    return index;
  }

}
