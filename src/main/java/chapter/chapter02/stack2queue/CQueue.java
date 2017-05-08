package chapter.chapter02.stack2queue;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Created by dong on 2017/5/4.
 */
public class CQueue<T> {

  protected final Logger logger = Logger.getLogger(getClass().getName());

  private Stack<T> store;
  private Stack<T> temp;

  public CQueue() {
    store = new Stack<T>();
    temp = new Stack<T>();
  }

  public void add(T t) {
    store.push(t);
  }

  public T removeFirst() {
    if (temp.isEmpty()) {
      while (!store.isEmpty()) {
        temp.push(store.pop());
      }
    }
    return temp.pop();
  }
}
