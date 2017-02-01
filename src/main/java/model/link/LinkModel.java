package model.link;

/**
 * 双向链表
 * Created by dong on 2016/12/7.
 */
public class LinkModel<T> {

  private LinkModel<T> previous;

  private T t;

  private LinkModel<T> latter;

  public void setPrevious(LinkModel<T> previous) {
    this.previous = previous;
  }

  public void setLatter(LinkModel<T> latter) {
    this.latter = latter;
  }

  public void setT(T t) {
    this.t = t;
  }

  public LinkModel<T> getLatter() {
    return latter;
  }

  public LinkModel<T> getPrevious() {
    return previous;
  }

  public T getT() {
    return t;
  }

  public LinkModel(T t) {
    this.t = t;
  }
}
