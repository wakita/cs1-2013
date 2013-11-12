package kwakita.cs1.s09hashcode;

/**
 * @author wakita
 *
 * HashSet を適切に用いることができるように equals メソッドに加えて，hashCode メソッドを上書きした例．
 */
public class PhoneNumber5 implements PhoneNumber {
        private final int areaCode, prefix, number;

        public PhoneNumber5(int a, int p, int n) {
            areaCode = rangeCheck(a, 999, "市街局番");
            prefix = rangeCheck(p, 9999, "市内局番");
            number = rangeCheck(n, 9999, "加入者番号");
        }

        private int rangeCheck(int arg, int max, String name) {
            if (arg < 0 || arg > max) throw new IllegalArgumentException(name
                    + ": "
                    + arg);
            return arg;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof PhoneNumber5)) return false;
            PhoneNumber5 x = (PhoneNumber5) o;
            return x.areaCode == areaCode && x.prefix == prefix
                    && x.number == number;
        }

        /** 
         * ハッシュ関数をいいかげんに実装すると本来のハッシュの性能が出ないと言われている．本当だろうか？
         * ここでは試しに常に0を返すハッシュ関数を作成してみた．
         * 
         * @see java.lang.Object#hashCode()
         */
        public int hashCode() {
            return 0;
        }

        public String toString() {
            return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
        }
    }
