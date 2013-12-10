package kwakita.cs1.s16prefer_composition;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest1 {
  private void run() {
    Properties 大学生 = new Properties();
    大学生.setProperty("大学", "大学生なのは確かだが，どこかは不明");
    
    Properties 典型的な東工生 = new Properties(大学生);
    典型的な東工生.setProperty("大学", "東工大");
    典型的な東工生.setProperty("性別", "男性");

    Set<Properties> 学生の集合 = new HashSet<Properties>();
    for (int i = 1; i <= 5; i++) {
      Properties 某男子学生 = new Properties(典型的な東工生);
      某男子学生.setProperty("なまえ", "太郎" + i);
      学生の集合.add(某男子学生);
    }

    Properties 典型的な東工大の女子学生 = new Properties(典型的な東工生);
    典型的な東工大の女子学生.setProperty("性別", "女性");
    for (int i = 1; i <= 2; i++) {
      Properties 某女子学生 = new Properties(典型的な東工大の女子学生);
      某女子学生.setProperty("性別", "女性");
      某女子学生.setProperty("なまえ", "花子" + i);
      学生の集合.add(某女子学生);
    }

    Properties お茶大生 = new Properties(大学生);
    お茶大生.setProperty("大学", "お茶大");
    お茶大生.setProperty("性別", "女性");
    お茶大生.setProperty("なまえ", "お嬢");
    学生の集合.add(お茶大生);

    System.out.println("s.getProperty(...) の結果");
    for (Properties s : 学生の集合) {
      System.out.printf("大学: %s, 性別: %s, 名前: %s\n", s.getProperty("大学"),
          s.getProperty("性別"), s.getProperty("なまえ"));
    }
    System.out.println("\ns.get(...) の結果");
    for (Properties s : 学生の集合) {
      System.out.printf("大学: %s, 性別: %s, 名前: %s\n", s.get("大学"), s.get("性別"),
          s.get("なまえ"));
    }
  }

  public static void main(String[] _) {
    new PropertiesTest1().run();
  }
}
