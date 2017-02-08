package chapter.chapter02.tree;

import java.util.Stack;
import model.tree.BTreeModel;
import org.apache.log4j.Logger;

/**
 * Created by dong on 2017/2/5.
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
    downLeft, upReady, downRight, up
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

  static class StatuModel<T> {

    private Step step = Step.downLeft;
    private BTreeModel<T> bTreeModel = null;

    public BTreeModel<T> getBTreeModel() {
      return bTreeModel;
    }

    public Step getStep() {
      return step;
    }

    public void setStep(Step step) {
      this.step = step;
    }

    public StatuModel(BTreeModel<T> bTreeModel) {
      this.bTreeModel = bTreeModel;
    }
  }
}
