package chapter.chapter02.sort;

/**
 * 直接插入排序
 *
 * O（n^2）
 * Created by dong on 2017/5/9.
 */
public class StraightInsertionSort {

  public void sort(int[] array) {
    if (array == null || array.length == 0) {
      throw new StraightInsertionSortException();
    }

    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        int j = i - 1;
        int x = array[i];
        array[i] = array[i - 1];
        while (j >= 0 &&x < array[j]) {
          array[j + 1] = array[j];
          j--;
        }
        array[j + 1] = x;
      }
    }
  }
}

class StraightInsertionSortException extends RuntimeException {

}
