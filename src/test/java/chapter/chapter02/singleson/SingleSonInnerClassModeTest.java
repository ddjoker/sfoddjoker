package chapter.chapter02.singleson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dong on 2016/12/10.
 */
public class SingleSonInnerClassModeTest {
    @Test
    public void getInstance() throws Exception {
        SingleSonInnerClassMode.getInstance();
    }

    /**
     * 加载的时候不会有任何执行,只是将类加载到内存中,不会触发静态方法调用
     * 只有尝试去实例化和调用内部方法的时候才会去进行静态模块的调用.
     * @throws Exception
     */
    @Test
    public void getInstance2() throws Exception {
        Class<SingleSonInnerClassMode> singleSonInnerClassModeClass = SingleSonInnerClassMode.class;
    }

}