package thiscase;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by dong on 2017/2/1.
 */
public class Log4jPrtTest {
  protected final Logger logger = LogManager.getLogger(this.getClass().getName());

  protected void logSomeThing(){
    logger.debug("some thing here");
  }

  public static void main(String[] args) {
    new Log4jPrtTest().logSomeThing();
  }
}
