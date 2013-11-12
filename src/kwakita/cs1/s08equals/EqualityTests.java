package kwakita.cs1.s08equals;

import static kwakita.cs1.U.*;

/**
 * @author wakita
 * 同値性の検査をするためのユーティリティ．
 */
public class EqualityTests {
    /**
     * 反射律の成立の有無を検査する．
     * @param x
     */
    public static void reflexivity(Object x) {
        if (!x.equals(x)) out.printf("エラー: %s に対して反射律が成立しません。\n\n", x);
        else out.printf("%sに対して反射律が成立しています。\n\n", x);
        out.flush();
    }

    /**
     * 対称律の成立の有無を検査する．
     * @param x
     * @param y
     */
    public static void symmetry(Object x, Object y) {
        if (x.equals(y) != y.equals(x)) out.printf(
                "エラー: %sと%sに対して対称律が成立しません。\n\n", x, y);
        else out.printf("%sと%sに対して対称律が成立しています。\n\n", x, y);
        out.flush();
    }

    private static boolean _transtivity(Object x, Object y, Object z) {
        if (x.equals(y) && y.equals(z) && !x.equals(z)) {
            out.printf(" - %s = %s かつ %s = %s ですが，\n   %s <> %s です。\n", x, y, y, z, x, z);
            return false;
        }
        return true;
    }

    /**
     * 推移律の成立の有無を検査する．
     * @param x
     * @param y
     * @param z
     */
    public static void transitivity(Object x, Object y, Object z) {
        boolean r = true;
        r &= _transtivity(x, y, z);
        r &= _transtivity(y, z, x);
        r &= _transtivity(z, x, y);
        r &= _transtivity(z, y, x);
        r &= _transtivity(y, x, z);
        r &= _transtivity(x, z, y);
        out.printf("%s, %s, %s に対して推移律が成立し%s．\n\n", x, y, z, r ? "ています" : "ません");
    }
}
