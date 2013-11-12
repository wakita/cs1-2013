package kwakita.cs1.s08equals;

import java.util.List;

public class Template {
    // 値として重要なものを表現するフィールド
    int x, y;
    long[] v;
    List<Object> list;
    // 値としては重要でないフィールド
    int a, b, c;

    public boolean equals(Object o) {
        // 比較のための計算が大変な場合には、this との == テストが高速化に有効
        if (o == this)
            return true;
        // 引数に与えられたオブジェクトがこのクラスのインスタンスであることを確認
        if (o instanceof Template) {
            // このクラスに型変換
            Template t = (Template) o;
            if (!(t.x == x && t.y == y)) return false;
            if (!java.util.Arrays.equals(v, t.v)) return false;
            List<Object> tv = t.list;
            if (!(tv.size() == list.size())) return false;
            for (int i = 0; i < list.size(); i++)
                if (!tv.get(i).equals(list.get(i))) return false;
            return true;
        }
        // 引数が null の場合は instanceof は false なので以下になる。
        return false;
    }
}
