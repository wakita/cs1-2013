package kwakita.cs1.s03singleton;

/**
 * @author wakita
 * Private constructor を用いて唯一性を保証した例．
 * このままでは，ある問題があって．serialize (正順化)に対応できない．
 */
public class Singleton1 implements Singleton {
  public static final Singleton INSTANCE = new Singleton1();

  // Item4: Private constructor (private 宣言されたコンストラクタ)によって"new Singleton1()"を禁止じる。
  private Singleton1() {
  }

  // 以下はおまけ
  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
