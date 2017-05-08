package chapter.chapter02.sort;

import java.util.Random;

/**
 * Created by dong on 2017/5/8.
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

}

/**
 * The type Invalid quick sort model exception.
 */
class InvalidQuickSortModelException extends RuntimeException {

}
