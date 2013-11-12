package kwakita.cs1.s09hashcode;

/**
 * @author wakita
 *
 * HashSet を適切に用いることができるように equals メソッドに加えて，hashCode メソッドを上書きした例．
 */
public class PhoneNumber4 implements PhoneNumber {
        private final int areaCode, prefix, number;

        public PhoneNumber4(int a, int p, int n) {
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
            if (!(o instanceof PhoneNumber4)) return false;
            PhoneNumber4 x = (PhoneNumber4) o;
            return x.areaCode == areaCode && x.prefix == prefix
                    && x.number == number;
        }

        /** 
         * hashCode の実装例．ハッシュ関数はクラスの「値」に該当するフィールドの値を組み合わせたものとする．
         * 
         * このクラスの値は，電話番号を構成する3つの番号で表されるので，これらを用いるのが適切．効果的なハッシュ関数を作成するには，ハッシュ関数が乱数関数のように振る舞うことが望ましい．逆にきれいな関数にするとハッシュの衝突が生じ，ハッシュの性能が悪化する．
         * 
         * ハッシュの衝突を避けるために，ここではハッシュ関数の計算に二つの素数を用い，衝突の周期を長く保とうとしている．ハッシュの性能と素数に関して詳しくはD. E. Knuth （クヌース）の本（たしか準数値算法の巻）を参考に．
         * 
         * @see java.lang.Object#hashCode()
         */
        public int hashCode() {
            int p0 = 13, p = 31;
            return ((p0 + areaCode) * p + prefix) * p + number;
        }

        public String toString() {
            return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
        }
    }
