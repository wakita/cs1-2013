package kwakita.cs1.s22static_member_class;

import static java.lang.System.out;

import java.util.Arrays;

public class AnonymousExample1 {
    private void run() {
        Object[] objects = new Object[] {
                new Object(),

                new Object() {
                    public String toString() { return "我輩はオブジェクトである。名前はまだない。"; }
                }
        };
        out.println(Arrays.toString(objects));
    }
    
    public static void main(String[] _) {
        new AnonymousExample1().run();
    }
}
