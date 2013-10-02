package kwakita.cs1.lecture01;

import static java.lang.System.out;

public class RightMostBit {
  /**
   * 最右ビット
   * 
   * @param bits
   * @return 最右ビットの位置
   */
  public long rightMostBit1(long bits) {
    for (long bit = 1; bit > 0; bit <<= 1)
      if ((bits & bit) == 0)
        return bit;
    return 0L;
  }

  /**
   * 引数[bits]のビット列のなかで最右の1ビットの位置のみを1とする値を返す。 (e.g., 10100111 => 00001000)
   * ただし、該当するビットがなければ0を返す。
   * 
   * @param bits
   *          任意の long 値
   * @return bits のなかで最右の1ビットの位置のみを1とする値
   */
  public final long rightMostBit2(long bits) {
    return ~bits & (bits + 1);
  }

  private void run() {
    for (long x = 0; x <= 16L; x++) {
      out.printf("%2d: %2d, %2d, %2d\n", x,
          ~x & (x + 1),
          this.rightMostBit1(x),
          this.rightMostBit2(x));
    }
  }

  public static void main(String[] _) {
    new RightMostBit().run();
  }
}
