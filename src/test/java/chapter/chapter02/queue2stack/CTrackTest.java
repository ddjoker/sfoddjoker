package chapter.chapter02.queue2stack;

import static org.junit.Assert.*;

import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/5/5.
 */
public class CTrackTest extends TestSupport {

  @Test
  public void test(){
    CTrack<Integer> cTrack = new CTrack<Integer>();
    cTrack.push(1);
    cTrack.push(2);
    cTrack.push(3);

    logger.info(toJson(cTrack.pop()));

    cTrack.push(4);
    cTrack.push(5);

    logger.info(toJson(cTrack.pop()));

    cTrack.push(6);

    logger.info(toJson(cTrack.pop()));

    cTrack.push(7);

    logger.info(toJson(cTrack.pop()));

    cTrack.push(8);
    cTrack.push(9);
    logger.info(toJson(cTrack.pop()));
  }
}