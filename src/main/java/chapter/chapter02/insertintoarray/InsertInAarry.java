package chapter.chapter02.insertintoarray;

/**
 * Created by dong on 2017/2/3.
 */
public class InsertInAarry {

  public static char[] replaceChar(char[] chars, char[] replacechars) {
    int length = chars.length;
    for (char c : chars) {
      if (c == ' ') {
        length += replacechars.length-1;
      }
    }
    char[] returnChar = new char[length];
    for (int i = 0, j = 0; i < chars.length & j < returnChar.length; i++) {
      if (chars[i] == ' ') {
        for (char replacechar : replacechars) {
          returnChar[j++] = replacechar;
        }
      } else {
        returnChar[j++] = chars[i];
      }
    }
    return returnChar;
  }
}
