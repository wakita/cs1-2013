package kwakita.cs1.s09hashcode;

/**
 * @author wakita
 *
 * HashSet を適切に用いることができるように equals メソッドに加えて，hashCode メソッドを上書きした例．
 */
public class PhoneNumber3 implements PhoneNumber {
        private final int areaCode, prefix, number;

        public PhoneNumber3(int a, int p, int n) {
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

        public int hashCode() {
            int p0 = 21, p = 31;
            return ((p0 + areaCode) * p + prefix) * p + number;
        }

        public String toString() {
            return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
        }
    }
