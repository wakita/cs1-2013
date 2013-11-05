package kwakita.cs1.s03singleton;

import java.io.Serializable;

public class Singleton2b implements Singleton, Serializable {
  private static final long serialVersionUID = 1517753241983195994L;

  private Object readResolve() {
    return INSTANCE;
  }

  private static final Singleton INSTANCE = new Singleton2b();

  public static Singleton getInstance() {
    return INSTANCE;
  }

  private Singleton2b() {
  }

  private static final String name = "この世の中で唯一無二の存在";

  public String toString() {
    return "私は" + name + "です。";
  }
}
