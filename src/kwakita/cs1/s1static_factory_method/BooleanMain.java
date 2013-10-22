package kwakita.cs1.s1static_factory_method;

public class BooleanMain {
  Boolean[] bools = null;
  Runtime r = Runtime.getRuntime();
  long space, time;

  private void at_start(String testname) {
    System.out.printf("%s: ", testname);
    bools = new Boolean[1 << 20];
    time = System.currentTimeMillis();
    System.gc();
    space = r.freeMemory();
  }

  private void at_stop() {
    long m = space - r.freeMemory();
    long t = System.currentTimeMillis() - time;
    System.out.printf("計算時間 - %4dms, メモリ使用量 - %8dB\n", t, m);
  }

  private void test_new() {
    at_start("[new]");
    for (int i = 0; i < bools.length; i++)
      bools[i] = new Boolean(i % 2 == 0);
    at_stop();
  }

  private void test_static_factory_method() {
    at_start("[sfm]");
    for (int i = 0; i < bools.length; i++)
      bools[i] = Boolean.valueOf(i % 2 == 0);
    at_stop();
  }

  private void run() {
    /*
     * 以下のループは一見無駄に見えるかもしれない。しかし、
     * Java でのプログラムの実行は Just-in-time compilation （
     * 実行時最適化) の影響で、徐々に高速化する。この影響を観察するために Java 
     * でベンチマークするときは、同じテストを数回繰り返すべきである。
     */
    for (int i = 1; i < 5; i++) {
      test_new();
      test_static_factory_method();
      System.out.println();
    }
  }

  public static void main(String[] _) {
    new BooleanMain().run();
  }
}
