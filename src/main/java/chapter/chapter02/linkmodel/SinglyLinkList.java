package chapter.chapter02.linkmodel;

import java.util.ArrayList;
import model.link.SinglyLinkModel;

/**
 * Created by dong on 2017/2/4.
 *
 * @param <T> the type parameter
 */
public class SinglyLinkList<T> {

  private SinglyLinkModel<T> head = null;
  private SinglyLinkModel<T> last = null;

  /**
   * Gets head.
   *
   * @return the head
   */
  public SinglyLinkModel<T> getHead() {
    return head;
  }

  /**
   * Add.
   *
   * @param value the value
   */
  public void add(T value) {
    if (head == null) {
      head = new SinglyLinkModel<T>(value);
      last = head;
      return;
    }
    while (last.getNext() != null) {
      last = last.getNext();
    }
    last.setNext(new SinglyLinkModel<T>(value));
    last = last.getNext();
  }

  /**
   * Find at t.
   *
   * @param index the index
   * @return the t
   */
  public T findAt(int index) {
    if (head == null) {
      throw new IndexOutOfBoundsException();
    }
    int i = 0;
    SinglyLinkModel<T> current = head;
    while ((current = current.getNext()) != null && i < index) {
      i++;
    }
    if (current != null) {
      return current.getValue();
    }

    throw new IndexOutOfBoundsException();
  }

  /**
   * Remove.
   *
   * @param index the index
   */
  public void remove(int index) {
    if (head == null) {
      throw new IndexOutOfBoundsException();
    }
    int i = 0;
    SinglyLinkModel<T> preModel = null;
    SinglyLinkModel<T> current = head;
    while ((current = current.getNext()) != null && i < index) {
      i++;
      preModel = current;
    }
    if (current != null) {
      preModel.setNext(current.getNext());
      return;
    }

    throw new IndexOutOfBoundsException();
  }


  /**
   * List array list.
   *
   * @return the array list
   */
  public ArrayList<T> list() {
    ArrayList<T> list = new ArrayList<T>();
    SinglyLinkModel<T> current = head;
    while ((current = current.getNext()) != null) {
      list.add(current.getValue());
    }
    return list;
  }


}
