package chapter.chapter02.singleson;

/**
 * 使用锁的单例模式, 效率不高
 * java-synchronized解析
 * http://ifeve.com/java-synchronized/
 * 同步锁耗时较长
 * Created by dong on 2016/12/10.
 */
public class SingleSonLockMode {
    private SingleSonLockMode() {

    }

    private static Byte[] lock = new Byte[0];
    private static SingleSonLockMode _instance = null;

    public synchronized static SingleSonLockMode getInstance() {
        if (_instance == null)
            _instance = new SingleSonLockMode();
        return _instance;
    }

    public static SingleSonLockMode getLockInstance() {
        synchronized (lock) {
            if (_instance == null)
                _instance = new SingleSonLockMode();
        }
        return _instance;
    }

}
