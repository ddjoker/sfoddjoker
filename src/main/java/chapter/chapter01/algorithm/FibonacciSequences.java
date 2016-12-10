package chapter.chapter01.algorithm;

/**
 * Created by dong on 2016/12/10.
 */
public class FibonacciSequences {

    public static long getNumAtN(int n) {
        long f1 = 1;
        long f2 = 0;
        long f3 = 0;
        for (int i = 0; i < n; i++) {
            f3 = f1 + f2;
          /*  if (i % 2 == 0)
                f1 = f3;
            else
                f2 = f3;*/
            f1 = f2;
            f2 = f3;
            System.out.println(f3);
        }
        return f3;
    }
}
