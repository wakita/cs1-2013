package kwakita.cs1.s09hashcode;

/**
 * PhoneNumber1 への反省から等価性 (equals) を実装した例．
 * 
 * 等価性に関するテストはパスするようになったが，hashCode メソッドを実装し忘れているために hashSet のような hashCode に依存したデータ構造を用いるとおかしなことになる．
 * @author wakita
 *
 */
public class PhoneNumber2 implements PhoneNumber {
        /**
         * 順に市街局番，市内局番，加入者番号
         */
        private final int areaCode, prefix, number;

        public PhoneNumber2(int a, int p, int n) {
            areaCode = rangeCheck(a, 999, "市街局番");
            prefix = rangeCheck(p, 9999, "市内局番");
            number = rangeCheck(n, 9999, "加入者番号");
        }

        /**
         * 与えられた数値が想定した範囲内で，正数であることの検査をする
         * @param arg 検査対象の数値
         * @param max 許される最大値
         * @param name フィールドの名前
         * @return
         */
        private int rangeCheck(int arg, int max, String name) {
            if (arg < 0 || arg > max) throw new IllegalArgumentException(name
                    + ": "
                    + arg);
            return arg;
        }

        /**
         * このクラスは「値クラス」なので，クラスの値に関する等価性 (equality) を定義する．
         * 
         * もちろん，値を構成するすべてのフィールドが同値であることを確認すればよい．
         * @see java.lang.Object#equals(java.lang.Object)
         */
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof PhoneNumber2)) return false;
            PhoneNumber2 x = (PhoneNumber2) o;
            return x.areaCode == areaCode && x.prefix == prefix
                    && x.number == number;
        }

        public String toString() {
            return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
            /*
             * String.format メソッドは C 言語の printf 関数や System.out.printf と同様に形式に合せた文字列を得るためのメソッド．
             * 最初の引数が出力形式を表している．%で始まる箇所にそれ以後の引数の値が順に収まる．
             * %の直後のいくつかの記号がどのような値をどのような形式で出力するかを指定する．
             * たとえば，ここで，ちなみに %04d は整数を2桁で表示し，4桁に満たない数は適宜0を詰めることを指示している．
             * ここで単純に (%d)%d-%d とすると，03-1234-0001 が 3-1234-1 と出力されてしまう．
             */
        }
    }

