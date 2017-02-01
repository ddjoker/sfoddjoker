package chapter.chapter02.singleson;

/**
 * 使用锁的单例模式, 两次判断 ,稍微提高效率
 * java-synchronized解析
 * http://ifeve.com/java-synchronized/
 * 同步锁耗时较长
 * Created by dong on 2016/12/10.
 */
public class SingleSonLockMode2 {

  private SingleSonLockMode2() {

  }

  private static Byte[] lock = new Byte[0];
  private static SingleSonLockMode2 _instance = null;

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static SingleSonLockMode2 getInstance() {
    if (_instance == null) {
      synchronized (lock) {
        if (_instance == null) {
          _instance = new SingleSonLockMode2();
        }
      }
    }
    return _instance;
  }

}
