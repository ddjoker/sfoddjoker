package test;

import com.google.gson.Gson;
import json.JsonBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

/**
 * Created by dong on 2017/2/1.
 */
public abstract class TestSupport {

  private long start = 0l;
  private long end = 0l;
  protected static final Logger logger = Logger.getLogger(TestSupport.class.getName());

  @Before
  public final void before() {
    logger.debug("start  = " + (start = System.currentTimeMillis()));
  }

  @After
  public final void after() {
    logger.debug("end  = " + (end = System.currentTimeMillis()));
    logger.debug("cost  = " + (end - start));
  }

  protected final String toJson(Object o ){
    return JsonBuilder.toJson(o);
  }
}
