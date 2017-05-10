package chapter.chapter02.sort;

/**
 * Created by dong on 2017/5/10.
 */
public class BubbleSort {

  public static void sort(int[] array) {
    int temp = 0;
    for (int i = array.length - 1; i > 0; --i) {
      boolean exchange = false;
      for (int j = 0; j < i; ++j) {
        if (array[j + 1] < array[j]) {
          exchange = true;
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
      if (!exchange) {
        return;
      }
    }
  }
}
