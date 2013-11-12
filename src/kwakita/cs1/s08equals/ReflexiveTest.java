package kwakita.cs1.s08equals;

import static kwakita.cs1.U.*;

import java.util.List;

/**
 * @author wakita
 * 恣意的に反射律を破壊したクラスの例
 */
class NotReflexive {
    public boolean equals(Object x) {
        if (x == this) return false;
        return super.equals(x);
    }
}

/**
 * @author wakita
 *
 * 反射律を破壊したオブジェクトの問題点を具体的に学ぶための実験．
 */
public class ReflexiveTest {
    /**
     * 反射律を破壊したオブジェクトをリストに追加しても，追加はできるものの，リストから取り出せない．
     */
    private void run() {
        List<NotReflexive> s = arrayList();
        NotReflexive x = new NotReflexive();
        s.add(x);

        System.out.printf("さっきのオブジェクトを持ってますか？ => %s\n\n", s.contains(x));
        System.out.printf("あれっ？でも，リストの要素数は%dだよ．\n", s.size());
    }

    public static void main(String[] _) {
        new ReflexiveTest().run();
    }
}
