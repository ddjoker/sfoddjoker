package chapter.chapter02.sort;

import java.util.Random;

/**
 * Created by dong on 2017/5/8.
 * O(logn)
 */
public class QuickSort {

  private int partition(Integer[] data, int length, int start, int end) {
    if (data == null || length <= 0 || start < 0 || end >= length) {
      throw new InvalidQuickSortModelException();
    }
    int index = new Random().nextInt(end - start) + start;
    swap(data, index, end);

    int small = start - 1;
    for (index = start; index < end; ++index) {
      if (data[index] < data[end]) {
        ++small;
        if (small != index) {
          swap(data, index, small);
        }
      }
    }
    ++small;
    swap(data, small, end);
    return small;
  }

  /**
   * Sort.
   *
   * @param data the data
   * @param length the length
   * @param start the start
   * @param end the end
   */
  public void sort(Integer[] data, int length, int start, int end) {
    if (start == end) {
      return;
    }

    int index = partition(data, length, start, end);
    if (index > start) {
      sort(data, length, start, index - 1);
    }
    if (index < end) {
      sort(data, length, index + 1, end);
    }
  }

  private void swap(Integer[] data, int first, int second) {
    int x = data[first] + data[second];
    data[first] = x - data[first];
    data[second] = x - data[second];
  }

  public  <T extends Comparable<? super T>> void quickSort(T[] targetArr, int start, int end) {
    int i = start, j = end;
    T key = targetArr[start];

    while (i < j) {
      /*按j--方向遍历目标数组，直到比key小的值为止*/
      while (j > i && targetArr[j].compareTo(key) >= 0) {
        j--;
      }
      if (i < j) {
      /*targetArr[i]已经保存在key中，可将后面的数填入*/
        targetArr[i] = targetArr[j];
        i++;
      }
      /*按i++方向遍历目标数组，直到比key大的值为止*/
      while (i < j && targetArr[i].compareTo(key) <= 0)
      /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/ {
        i++;
      }
      if (i < j) {
      /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
        targetArr[j] = targetArr[i];
        j--;
      }
    }
    /*此时i==j*/
    targetArr[i] = key;

    /*递归调用，把key前面的完成排序*/
    this.quickSort(targetArr, start, i - 1);


    /*递归调用，把key后面的完成排序*/
    this.quickSort(targetArr, j + 1, end);

  }


}

/**
 * The type Invalid quick sort model exception.
 */
class InvalidQuickSortModelException extends RuntimeException {

}
