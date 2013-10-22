package kwakita.cs1.s1static_factory_method;

import java.util.*;

import kwakita.cs1.U;

public class HashMapMain {
  private void run1() {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    {
      List<String> list = new ArrayList<String>();
      list.add("カレーライス");
      list.add("コーヒー");
      map.put("昼食", list);
    }
  }

  private void run2() {
    Map<String, List<String>> map = U.hashMap();
    {
      List<String> list = U.arrayList();
      list.add("カレーライス");
      list.add("コーヒー");
      map.put("昼食", list);
    }
  }

  private void run() {
    run1();
    run2();
  }

  public static void main(String[] _) {
    new HashMapMain().run();
  }
}
