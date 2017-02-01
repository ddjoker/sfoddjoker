package chapter.chapter01;

/**
 * Created by dong on 2016/12/5.
 */
public class String2Int {

  public static int string2Int(String args) throws NumberFormatException {
    int returnValue = 0;
    try {
      returnValue = Integer.valueOf(args);
    } catch (NumberFormatException e) {
    }
    return returnValue;
  }
}
