package chapter.chapter02.singleson;

/**
 * 只适用于单线程的单例模式
 * Created by dong on 2016/12/10.
 */
public class SingleSonSingleThread {

  private SingleSonSingleThread() {

  }

  private static SingleSonSingleThread _instance = null;

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static SingleSonSingleThread getInstance() {
    if (_instance == null) {
      _instance = new SingleSonSingleThread();
    }
    return _instance;
  }

}
