package thiscase;

/**
 * Created by dong on 2017/2/1.
 */
public class Log4jThisTest  extends  Log4jPrtTest{
  protected void logSomeThing(){
    logger.debug("some thing here");
  }
  public static void main(String[] args) {
    new Log4jThisTest().logSomeThing();
  }
}
