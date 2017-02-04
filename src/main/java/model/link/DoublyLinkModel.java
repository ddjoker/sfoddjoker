package model.link;

/**
 * 双向链表
 * Created by dong on 2016/12/7.
 *
 * @param <T> the type parameter
 */
public class DoublyLinkModel<T> {

  private DoublyLinkModel<T> previous;

  private T value;

  private DoublyLinkModel<T> latter;

  /**
   * Sets previous.
   *
   * @param previous the previous
   */
  public void setPrevious(DoublyLinkModel<T> previous) {
    this.previous = previous;
  }

  /**
   * Sets latter.
   *
   * @param latter the latter
   */
  public void setLatter(DoublyLinkModel<T> latter) {
    this.latter = latter;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Gets latter.
   *
   * @return the latter
   */
  public DoublyLinkModel<T> getLatter() {
    return latter;
  }

  /**
   * Gets previous.
   *
   * @return the previous
   */
  public DoublyLinkModel<T> getPrevious() {
    return previous;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public T getValue() {
    return value;
  }

  /**
   * Instantiates a new Link model.
   *
   * @param t the value
   */
  public DoublyLinkModel(T t) {
    this.value = t;
  }
}
