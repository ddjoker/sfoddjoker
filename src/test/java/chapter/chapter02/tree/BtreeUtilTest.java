package chapter.chapter02.tree;

import model.tree.BTreeModel;
import org.junit.Test;
import test.TestSupport;

/**
 * Created by dong on 2017/2/6.
 */
public class BtreeUtilTest extends TestSupport {

  @Test
  public void afterSequeuLoopTraversal() throws Exception {
    BtreeUtil.afterSequeuLoopTraversal(initBTree());
  }

  @Test
  public void sequeuLoopTraversal() throws Exception {
    BtreeUtil.sequeuLoopTraversal(initBTree());
  }

  @Test
  public void preorderLoopTraversal() throws Exception {
    BtreeUtil.preorderLoopTraversal(initBTree());
  }

  /**
   * After sequeue recursion traversal.
   *
   * @throws Exception the exception
   */
  @Test
  public void afterSequeueRecursionTraversal() throws Exception {
    BtreeUtil.afterSequeueRecursionTraversal(initBTree());
  }

  /**
   * Sequeue recursion traversal.
   *
   * @throws Exception the exception
   */
  @Test
  public void sequeueRecursionTraversal() throws Exception {
    BtreeUtil.sequeueRecursionTraversal(initBTree());
  }

  private BTreeModel<Integer> initBTree() {
    BTreeModel<Integer> bTreeModel = new BTreeModel<Integer>(10);

    bTreeModel.setLeftChild(new BTreeModel<Integer>(6));
    bTreeModel.getLeftChild().setLeftChild(new BTreeModel<Integer>(4));
    bTreeModel.getLeftChild().getLeftChild().setLeftChild(new BTreeModel<Integer>(1));
    bTreeModel.getLeftChild().getLeftChild().setRightChild(new BTreeModel<Integer>(2));
    bTreeModel.getLeftChild().setRightChild(new BTreeModel<Integer>(8));
    bTreeModel.getLeftChild().getRightChild().setLeftChild(new BTreeModel<Integer>(5));
    bTreeModel.getLeftChild().getRightChild().setRightChild(new BTreeModel<Integer>(7));

    bTreeModel.setRightChild(new BTreeModel<Integer>(14));
    bTreeModel.getRightChild().setLeftChild(new BTreeModel<Integer>(12));
    bTreeModel.getRightChild().setRightChild(new BTreeModel<Integer>(16));
    bTreeModel.getRightChild().getRightChild().setLeftChild(new BTreeModel<Integer>(15));
    bTreeModel.getRightChild().getRightChild().setRightChild(new BTreeModel<Integer>(17));
    return bTreeModel;
  }

  /**
   * Preorder recursion traversal.
   *
   * @throws Exception the exception
   */
  @Test
  public void preorderRecursionTraversal() throws Exception {
    BtreeUtil.preorderRecursionTraversal(initBTree());
  }

}