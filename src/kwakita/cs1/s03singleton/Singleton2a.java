package kwakita.cs1.s03singleton;

import java.io.Serializable;

/**
 * @author wakita
 * Singleton1a と同様に serialize操作に対応させるために serialVersionUID を追加．
 * やはり，Singleton1a と同様に serialize はできるものの，singleton な性質が破壊される余地を残している．
 */
public class Singleton2a implements Singleton, Serializable {
  private static final long        serialVersionUID = -1637116701265395735L;

  private static final Singleton2a INSTANCE         = new Singleton2a();

  public static Singleton2a getInstance() {
    return INSTANCE;
  }

  private Singleton2a() {
  }

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
