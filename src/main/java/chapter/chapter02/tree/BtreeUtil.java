package chapter.chapter02.tree;

import java.util.Stack;
import model.tree.BTreeModel;
import org.apache.log4j.Logger;

/**
 * Created by dong on 2017/2/5.
 * 前序遍历是   顶-->左--右
 * 中序遍历是   左-->顶-->右
 * 后序遍历是   左-->右-->顶
 *
 * @param <T> the type parameter
 */
public class BtreeUtil {

  private static Logger logger = Logger.getLogger(BtreeUtil.class);

  /**
   * 前序遍历的递归写法
   * Preorder recursion traversal.
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void preorderRecursionTraversal(BTreeModel<T> bTreeModel) {
    if (bTreeModel == null) {
      return;
    }
    logger.info(bTreeModel.getValue());
    preorderRecursionTraversal(bTreeModel.getLeftChild());
    preorderRecursionTraversal(bTreeModel.getRightChild());
  }

  /**
   * 前序遍历的循环写法
   * Preorder loop traversal.
   * 有点象红黑树
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void preorderLoopTraversal(BTreeModel<T> bTreeModel) {

    BTreeModel<T> current = bTreeModel;
    Stack<BTreeModel<T>> stack = new Stack<BTreeModel<T>>();
    boolean stepLeft = true;
    while (true) {
      if (current != null) {
        logger.info(current.getValue());
        stack.push(current);
        stepLeft = true;
      } else {
        if (stack.empty()) {
          break;
        }
        current = stack.pop();
        stepLeft = false;
      }

      if (stepLeft) {
        current = current.getLeftChild();
      } else {
        current = current.getRightChild();
      }
    }
  }

  /**
   * 中序遍历的递归写法
   * Sequeue recursion traversal.
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void sequeueRecursionTraversal(BTreeModel<T> bTreeModel) {
    if (bTreeModel == null) {
      return;
    }
    sequeueRecursionTraversal(bTreeModel.getLeftChild());
    logger.info(bTreeModel.getValue());
    sequeueRecursionTraversal(bTreeModel.getRightChild());
  }

  /**
   * 中序遍历的循环写法
   * Sequeu loop traversal.
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void sequeuLoopTraversal(BTreeModel<T> bTreeModel) {

    BTreeModel<T> current = bTreeModel;
    Stack<BTreeModel<T>> stack = new Stack<BTreeModel<T>>();
    boolean stepLeft = true;
    while (true) {
      if (current != null) {
        stack.push(current);
        stepLeft = true;
      } else {
        if (stack.empty()) {
          break;
        }
        current = stack.pop();
        logger.info(current.getValue());
        stepLeft = false;
      }

      if (stepLeft) {
        current = current.getLeftChild();
      } else {
        current = current.getRightChild();
      }
    }
  }

  /**
   * 后序遍历的递归写法
   * After sequeue recursion traversal.
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void afterSequeueRecursionTraversal(BTreeModel<T> bTreeModel) {
    if (bTreeModel == null) {
      return;
    }
    afterSequeueRecursionTraversal(bTreeModel.getLeftChild());
    afterSequeueRecursionTraversal(bTreeModel.getRightChild());
    logger.info(bTreeModel.getValue());
  }

  private enum Step {
    /**
     * Down left step.
     */
    downLeft, /**
     * Up ready step.
     */
    upReady, /**
     * Down right step.
     */
    downRight, /**
     * Up step.
     */
    up
  }

  /**
   * 后序遍历的循环写法 (通用)
   * After sequeu loop traversal.
   *
   * @param <T> the type parameter
   * @param bTreeModel the b tree model
   */
  public static <T> void afterSequeuLoopTraversal(BTreeModel<T> bTreeModel) {
    StatuModel<T> current = new StatuModel<T>(bTreeModel);
    Stack<StatuModel<T>> stack = new Stack<StatuModel<T>>();
    Step step = Step.downLeft;
    BTreeModel<T> temp = null;
    boolean stepLeft = true;
    while (true) {

      if (current.getStep() != Step.upReady) {
        stack.push(current);
      }
      if (current.getStep() == Step.downLeft) {
        current.setStep(Step.downRight);
        //  logger.info(current.getBTreeModel().getValue());  前序
        if (current.getBTreeModel().getLeftChild() != null) {
          current = new StatuModel<T>(current.getBTreeModel().getLeftChild());
          continue;
        }
      }

      if (current.getStep() == Step.downRight) {
        current.setStep(Step.upReady);
        //  logger.info(current.getBTreeModel().getValue());  中序
        if (current.getBTreeModel().getRightChild() != null) {
          current = new StatuModel<T>(current.getBTreeModel().getRightChild());
          continue;
        }
      }
      if (current.getStep() == Step.upReady) {
        logger.info(current.getBTreeModel().getValue()); //后序
        current.setStep(Step.up);
        if (!stack.empty()) {
          current = stack.pop();
        }
      }

      if (current.getStep() == Step.up) {
        if (!stack.empty()) {
          current = stack.pop();
        }
      }

      if (current.getStep() == Step.up) {
        break;
      }

    }
  }

  /**
   * Rebuild btree b tree model.
   * <P>
   * 根据前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建二叉树
   * </P>
   *
   * @param <T> the type parameter
   * @param preorder the preorder list
   * @param inorder the sequeue list
   * @return the b tree model
   * @throws Exception the exception
   */
  public static <T> BTreeModel<T> rebuildBtree(T[] preorder, T[] inorder) throws Exception {

    if (preorder == null) {
      return null;
    }
    if (preorder.length == 0) {
      return null;
    }
    if (inorder == null) {
      return null;
    }
    if (inorder.length == 0) {
      return null;
    }
    return constructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  /**
   * Construct core b tree model.
   *
   * @param <T> the type parameter
   * @param preOrder the pre order
   * @param startPreIndex 前序序列开始位置
   * @param endPreIndex 前序序列结束位置
   * @param inOrder the in order
   * @param startInIndex 中序序列开始位置
   * @param endInIndex 中序序列结束位置
   * @return 根结点 b tree model
   * @throws InvalidPutException the invalid put exception
   */
  public static <T> BTreeModel<T> constructCore(T[] preOrder, int startPreIndex, int endPreIndex,
      T[] inOrder, int startInIndex, int endInIndex) throws InvalidPutException {

    T rootValue = preOrder[startPreIndex];
    System.out.println("rootValue = " + rootValue);
    BTreeModel<T> root = new BTreeModel<T>(rootValue);

    // 只有一个元素
    if (startPreIndex == endPreIndex) {
      if (startInIndex == endInIndex
          && preOrder[startPreIndex] == inOrder[startInIndex]) {
        System.out.println("only one element");
        return root;
      } else {
        throw new InvalidPutException();
      }
    }

    // 在中序遍历中找到根结点的索引
    int rootInIndex = startInIndex;

    while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
      ++rootInIndex;
    }

    if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
      throw new InvalidPutException();

    }

    int leftLength = rootInIndex - startInIndex;

    int leftPreOrderEndIndex = startPreIndex + leftLength;

    if (leftLength > 0) {
      // 构建左子树
      root.setLeftChild(constructCore(preOrder, startPreIndex + 1,
          leftPreOrderEndIndex, inOrder, startInIndex,
          rootInIndex - 1));
    }

    if (leftLength < endPreIndex - startPreIndex) {
      // 右子树有元素,构建右子树
      root.setRightChild(constructCore(preOrder, leftPreOrderEndIndex + 1,
          endPreIndex, inOrder, rootInIndex + 1, endInIndex));
    }
    return root;
  }

  /**
   * The type Statu model.
   *
   * @param <T> the type parameter
   */
  static class StatuModel<T> {

    private Step step = Step.downLeft;
    private BTreeModel<T> bTreeModel = null;

    /**
     * Gets b tree model.
     *
     * @return the b tree model
     */
    public BTreeModel<T> getBTreeModel() {
      return bTreeModel;
    }

    /**
     * Gets step.
     *
     * @return the step
     */
    public Step getStep() {
      return step;
    }

    /**
     * Sets step.
     *
     * @param step the step
     */
    public void setStep(Step step) {
      this.step = step;
    }

    /**
     * Instantiates a new Statu model.
     *
     * @param bTreeModel the b tree model
     */
    public StatuModel(BTreeModel<T> bTreeModel) {
      this.bTreeModel = bTreeModel;
    }
  }


}

/**
 * The type Invalid put exception.
 */
class InvalidPutException extends Exception {

}
