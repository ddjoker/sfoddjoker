package chapter.chapter02.sort;

/**
 * Created by dong on 2017/5/9.
 */
public class ShellSort {
  public static void sort(int array[]) {
    if(array == null || array.length == 0 )
      throw new ShellSortModelException();
    int length = array.length;
    int temp = 0;
    for (int gap = length / 2; gap >= 1; gap = gap / 2)
      for (int i = gap; i < length; i++)
        for (int j = i; j >= gap && array[j] < array[j - gap]; j -= gap) {
          temp = array[j];
          array[j] = array[j - gap];
          array[j - gap] = temp;
        }
  }
}
class ShellSortModelException extends RuntimeException{}
