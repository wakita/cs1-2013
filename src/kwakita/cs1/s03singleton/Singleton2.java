package kwakita.cs1.s03singleton;

/**
 * @author wakita
 * Item 1: static factory method を用いた実装の基本形
 * Singleton1 と同様にこのままでは serialize 操作に対応していない．
 */
public class Singleton2 implements Singleton {
  // INSTANCE も隠蔽してしまう．
  private static final Singleton2 INSTANCE = new Singleton2();

  // Item 4: Private constructor で new できないようにしているのは，Singleton1 と同様．
  private Singleton2() {
  }

  // Item 1: Static factory method を提供する．
  public static Singleton2 getInstance() {
    return INSTANCE;
  }

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
