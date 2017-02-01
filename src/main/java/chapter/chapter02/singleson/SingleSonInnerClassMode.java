package chapter.chapter02.singleson;

/**
 * 使用静态内部类去创建对象的单例实例,
 * 而静态内部类的静态方法和属性只会在当前内部类在显示调用的时候才会初始化,
 * 这样就做到了保证类的唯一性的同时达到按需加载的目的
 * Created by dong on 2016/12/10.
 */
public class SingleSonInnerClassMode {

  private SingleSonInnerClassMode() {
    //第三层调用
    System.out.println("SingleSonInnerClassMode  Constructor ");
  }

  static {
    // 第一层调用
    System.out.println("SingleSonInnerClassMode Static");
  }


  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static SingleSonInnerClassMode getInstance() {
    return Instance._instance;
  }

  /**
   * 不允许外界显示调用
   */
  private static class Instance {

    static {
      //第二层调用
      System.out.println("SingleSonInnerClassMode  Instance  Static");
    }

    /**
     * The constant _instance.
     */
    public final static SingleSonInnerClassMode _instance = new SingleSonInnerClassMode();
  }
}
