package chapter.chapter02.singleson;

/**
 * 使用静态创建的方式去获取单例
 * 当次类加载的时候就直接创建对象,保证唯一性
 * 会降低内存使用效率
 * Created by dong on 2016/12/10.
 */
public class SingleSonStaticMode {

  private SingleSonStaticMode() {

  }

  private static SingleSonStaticMode _instance = new SingleSonStaticMode();

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static SingleSonStaticMode getInstance() {
    return _instance;
  }

}
