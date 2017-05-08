package chapter.chapter02.queue2stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by dong on 2017/5/4.
 */
public class CTrack<T> {

  private Queue<T> store;
  private Queue<T> temp;

  public CTrack() {
    store = new ArrayDeque<T>();
    temp = new ArrayDeque<T>();
  }

  public void push(T t) {
    store.add(t);
  }

  public T pop() {
    if (temp.isEmpty()) {
      while (!store.isEmpty()) {
        temp.add(store.poll());
      }
    }
    return temp.poll();
  }

}
