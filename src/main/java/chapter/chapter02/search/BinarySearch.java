package chapter.chapter02.search;

import java.util.List;

/**
 * Created by dong on 2017/5/8.
 */
public class BinarySearch {

  public static boolean search(List<Integer> ascSortedList, int key) {
    List<Integer> searchList = ascSortedList;
    while (true) {

      int result = Integer.compare(searchList.get(searchList.size() / 2), key);
      if (result > 0) {

        searchList = searchList.subList(0, searchList.size() / 2);
      } else if (result < 0) {
        searchList = searchList.subList(searchList.size() / 2, searchList.size());
      } else {
        return true;
      }
      if(searchList.size()/2 ==0)
        break;
    }

    throw new NoResultException();
  }

}

class NoResultException extends RuntimeException {

}
