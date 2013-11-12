package kwakita.cs1.s08equals;

import static kwakita.cs1.U.*;

import java.util.List;

/**
 * @author wakita
 * 大文字・小文字の違いを無視した文字列
 * うっかりと反射律を破壊してしまった実装
 */
final class MyString {
    private final String s;

    public MyString(String s) {
        if (s == null) throw new NullPointerException();
        this.s = s;
    }

    public boolean equals(Object o) {
        if (o instanceof MyString) return s.equalsIgnoreCase(((MyString) o).s);
        if (o instanceof String) return s.equalsIgnoreCase((String) o);
        return false;
    }

    /**
     * 表示するときに，通常の String クラスのインスタンスと MyString クラスのインスタンスを区別するために，後者には文字列の内容に続けて
     * "@MyString" をつけて区別している．
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return s + "@MyString";
    }
}

public class SymmetryTest1 {
    /**
     * リストにオブジェクトを挿入して見つかるか確認する実験．
     * @param s
     */
    private void test2(Object... s) {
        List<Object> list = arrayList();

        int i = 0;
        for (Object x : s) {
            list.add(x);
            out.printf(" - list[%d] = %15s;  index@%d = %15s\n", i,
                    list.get(i), list.indexOf(x), list.get(list.indexOf(x)));
            // get, indexOf の働きについては List インタフェイスのマニュアルで調べること．
            i++;
        }
        out.println();

        /*Set<Object> set = treeSet();
		for (Object o : s) set.add(o);
		System.out.println(java.util.Arrays.toString(set.toArray(new Object [] {})));

		set.clear();
		for (i = s.length - 1; i >= 0; i--) set.add(s[i]);
		System.out.println(java.util.Arrays.toString(set.toArray(new Object [] {})));
         */	
    }

    private void run() {
        MyString titech = new MyString("titech"), TITECH = new MyString(
                "TITECH");
        String titech_s = "titech";
        EqualityTests.symmetry(titech, TITECH);
        EqualityTests.symmetry(titech, titech_s);

        out.println("test1でわかった事実から以下のおかしな現象を説明しなさい。");
        test2(TITECH, titech_s);
        test2(titech_s, TITECH);
    }

    public static void main(String[] _) {
        new SymmetryTest1().run();
    }
}
