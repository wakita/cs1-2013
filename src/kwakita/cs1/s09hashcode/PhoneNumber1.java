package kwakita.cs1.s09hashcode;

/**
 * @author wakita 電話番号の素朴な実装．値クラスにも関わらず等価性 (equals)を定義していないために，さまざまな問題を起こす．
 * 
 *         ところで計算機科学でカジュアルに用いられる「素朴」はnaiveの日本語訳．日本人が使うナイーブには「繊細な」
 *         といった意味をこめられているようだが ，計算機科学で「素朴」とされるのは，「ほとんど何も考えていない」に近く，
 *         大概は否定的な意味で用いられる．
 *         もちろん，単純な考え方にも関わらず，他のいたずらに複雑な考え方よりも優れている場合もあるので，常に否定的な文脈とは限らない．
 *         
 *         西洋の啓蒙思想家たちは素朴な子供に適切な教育を施すことによって，洗練された大人となるとしたことが背景となって，
 *         東洋のように素朴さを賛美する文化に乏しいことが背景になっていると思われる．
 */
public class PhoneNumber1 implements PhoneNumber {
        /**
         * 順に市街局番，市内局番，加入者番号
         */
        private final int areaCode, prefix, number;

        public PhoneNumber1(int a, int p, int n) {
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

