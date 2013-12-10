package kwakita.cs1.s16prefer_composition;

import java.util.Properties;

public class PropertiesTest2 {
  class おにぎり {
    public String toString() { return "おにぎり"; }
  }

  private void run() {
    Properties ごんべ = new Properties();

    ごんべ.setProperty("なまえ", "名無しのごんべ");
    ごんべ.put("にもつ", new おにぎり());

    System.out.println(ごんべ);
    System.out.printf("なまえ: %s\n", ごんべ.getProperty("なまえ"));
    System.out.printf("にもつ: %s\n", ごんべ.getProperty("にもつ"));
    System.out.printf("にもつ: %s\n", ごんべ.get("にもつ"));
  }

  public static void main(String[] _) {
    new PropertiesTest2().run();
  }
}
