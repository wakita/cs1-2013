package kwakita.cs1.s03singleton;

/**
 * @author wakita
 * Java 5 から導入された enum 機能を利用した実装．
 * serialVersionUIDやreadResolveの面倒を見る必要から解放されて，簡単． 
 */
public enum Singleton3 implements Singleton {
  INSTANCE;

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
