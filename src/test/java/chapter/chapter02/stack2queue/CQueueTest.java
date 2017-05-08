package chapter.chapter02.stack2queue;

import static org.junit.Assert.*;

import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/4.
 */
public class CQueueTest extends TestSupport {

  @Test
  public void test() throws Exception {
    CQueue<Integer> cQueue = new CQueue<Integer>();
    cQueue.add(1);
    cQueue.add(2);
    cQueue.add(3);

    logger.info(toJson(cQueue.removeFirst()));

    cQueue.add(4);
    cQueue.add(5);

    logger.info(toJson(cQueue.removeFirst()));

    cQueue.add(6);

    logger.info(toJson(cQueue.removeFirst()));

    cQueue.add(7);

    logger.info(toJson(cQueue.removeFirst()));

    cQueue.add(8);
    cQueue.add(9);
    logger.info(toJson(cQueue.removeFirst()));
  }


}