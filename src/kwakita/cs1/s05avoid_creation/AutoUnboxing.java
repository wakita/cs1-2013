package kwakita.cs1.s05avoid_creation;

public class AutoUnboxing {
  private long run1() {
    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++)
      sum += i;
    return sum;
  }

  private long run2() {
    long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++)
      sum += i;
    return sum;
  }

  private void run() {
    long time = System.currentTimeMillis();
    run1();
    System.out.printf("実行時間 = %.2f秒\n",
        (System.currentTimeMillis() - time) / 1000.0);
    time = System.currentTimeMillis();
    run2();
    System.out.printf("実行時間 = %.2f秒\n",
        (System.currentTimeMillis() - time) / 1000.0);
  }

  public static void main(String... _) {
    new AutoUnboxing().run();
  }
}
