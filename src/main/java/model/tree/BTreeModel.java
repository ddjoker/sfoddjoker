package model.tree;

/**
 * Created by dong on 2017/2/5.
 *
 * @param <T> the type parameter
 */
public class BTreeModel<T> {

  private T value;
  private BTreeModel<T> leftChild;
  private BTreeModel<T> rightChild;

  /**
   * Instantiates a new B tree model.
   *
   * @param value the value
   */
  public BTreeModel(T value) {
    this.value = value;
  }

  /**
   * Instantiates a new B tree model.
   */
  public BTreeModel() {
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
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Gets left child.
   *
   * @return the left child
   */
  public BTreeModel<T> getLeftChild() {
    return leftChild;
  }

  /**
   * Sets left child.
   *
   * @param leftChild the left child
   */
  public void setLeftChild(BTreeModel<T> leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Gets right child.
   *
   * @return the right child
   */
  public BTreeModel<T> getRightChild() {
    return rightChild;
  }

  /**
   * Sets right child.
   *
   * @param rightChild the right child
   */
  public void setRightChild(BTreeModel<T> rightChild) {
    this.rightChild = rightChild;
  }

}
