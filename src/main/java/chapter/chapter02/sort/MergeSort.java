package chapter.chapter02.sort;

/**
 * Created by dong on 2017/5/11.
 */
public class MergeSort {
  public static void sort(int[] array) {
    int[] tempArray = new int[array.length];
    mergeSort(array, tempArray, 0, array.length - 1);
  }

  private static void mergeSort(int[] array, int[] tempArray, int left, int right ) {
    if ( left < right ) {
      int center = ( left + right ) / 2;
      mergeSort(array, tempArray, left, center);
      mergeSort(array, tempArray, center + 1, right);
      merge(array, tempArray, left, center + 1, right);
    }
  }

  private static void merge( int[] array, int[] tempArray, int left, int right, int end) {
    int tempLeft = left;
    int tempRight = right;
    int position = left;

    while(tempLeft < right && tempRight <= end){//两个队列都没到头
      if(array[tempLeft] < array[tempRight])
        tempArray[position++] = array[tempLeft++];
      else
        tempArray[position++] = array[tempRight++];
    }

    while(tempLeft < right){
      tempArray[position++] = array[tempLeft++];
    }

    while(tempRight <= end){
      tempArray[position++] = array[tempRight++];
    }

    for(int index = left; index <= end; index++){//复制回去
      array[index] = tempArray[index];
    }
  }

}
