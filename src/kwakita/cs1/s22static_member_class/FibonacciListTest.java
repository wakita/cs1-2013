package kwakita.cs1.s22static_member_class;

import static java.lang.System.out;

import org.junit.Test;

public class FibonacciListTest {

    @Test
    public void fibonacci() {
        FibonacciList v = new FibonacciList();
        for (int i = 0; i < 1000; i++) v.add(i);
        
        System.out.println("Fibonacciリストの全要素を出力");
        System.out.println(v);
        
        System.out.println("Fibonacciリストの要素をイタレータを用いて出力");
        int i = 0;
        for (int n : v) {
            out.printf("v[%d] = %d\n", i, n);
            i++;
        }
    }
}