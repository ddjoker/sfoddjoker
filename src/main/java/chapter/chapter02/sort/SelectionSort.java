package chapter.chapter02.sort;

/**
 * Created by dong on 2017/5/11.
 */
public class SelectionSort {
  public static void sort(int[] array) {
    int temp;
    int min;
    for (int index = 0; index < array.length - 1; index++) {
      min = index;
      for (int next = index + 1; next < array.length; next++) {
        if (array[next] < (array[min])) {
          min = next;
        }
      }
      temp = array[index];
      array[index] = array[min];
      array[min] = temp;
    }
  }
}
