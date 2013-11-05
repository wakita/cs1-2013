package kwakita.cs1.s03singleton;

import java.io.Serializable;

// Singleton なオブジェクトの複製をされると困る。
// Serialize/Unserialize でオブジェクトを一旦バイト列化し、それを元に戻す処理で複製ができるかどうか実験

/**
 * @author wakita
 * Singleton1 クラスを若干修正し，serialize (正順化)操作に対応させた
 * 普通は serialVersionUID を追加すればよいのだが，それだけでは unserialize したときに
 * singleton の性質が破られてしまう．
 */
public class Singleton1a implements Singleton, Serializable {
  // Serializable を実装すると要求されるのが以下の謎の ID
  // Eclipse の機能でクラス名からハッシュ値を計算するものを使った
  private static final long     serialVersionUID = -1668322590282967809L;

  public static final Singleton INSTANCE         = new Singleton1a();

  private Singleton1a() {
  }

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
