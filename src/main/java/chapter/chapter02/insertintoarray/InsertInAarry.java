package chapter.chapter02.insertintoarray;

/**
 * <p>
 * 原题需要判断是否可以使用新的内存.<br/>
 * 而在JAVA中数组只能重新分配新的内存.<br/>
 * 如果使用链表难度就变的很低...  <br/>
 * 所以我们在考虑使用新的内存的情况下,就没有什么可能的错误了
 * </p>
 * <p>
 * <h2>要点:</h2>
 * <ul>
 * <li>分析时间效率的能力,分析不同方法的时间效率</li>
 * <li>分析潜在问题,与面试官沟通</li>
 * </ul>
 * </p>
 * Created by dong on 2017/2/3.
 */
public class InsertInAarry {

  /**
   * Replace char char [ ].
   * 错误点:是没有进行判断
   * @param chars the chars
   * @param replacechars the replacechars
   * @return the char [ ]
   */
  public static char[] replaceChar(char[] chars, char[] replacechars) {
    //要注意对每一个传入参数进行可靠性判断.
    if(chars ==null)
      return null;
    if(replacechars == null)
      return null;
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
