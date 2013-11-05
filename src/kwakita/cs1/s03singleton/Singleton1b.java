package kwakita.cs1.s03singleton;

import java.io.Serializable;

/**
 * @author wakita
 * serialize (正順化)操作によって，singletonの性質を保証するように，serializeの際に呼び出される特殊なメソッド(readResolve)を上書きした．
 */
public class Singleton1b implements Singleton, Serializable {
  private static final long serialVersionUID = -854105007273143543L;

  // 複製を抑制するために、unserializeのときに呼ばれるメソッドを上書きし、
  // 定数を返すことで複製の作成を抑制
  private Object readResolve() {
    return INSTANCE;
  }

  public static final Singleton INSTANCE = new Singleton1b();

  private Singleton1b() {
  }

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
