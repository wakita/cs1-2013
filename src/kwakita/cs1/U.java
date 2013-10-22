package kwakita.cs1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class U {
  /*
   *  コンストラクタを private 宣言することで、このクラスを new できないように設定している。
   *  このクラスのようなユーティリティを定義するクラスを定義するときの常套手段です。
   *  Effective Java: Item 4 --- Private constructor
   */
  private U() {}

  public static final InputStream in = System.in;
  public static final PrintStream out = System.out, err = System.err;

  public static <V> List<V> arrayList() { return new ArrayList<V>(); }

  public static <V> Set<V> treeSet() { return new TreeSet<V>(); }
  public static <V> Set<V> hashSet() { return new HashSet<V>(); }

  public static <K, V> Map<K, V> hashMap() { return new HashMap<K, V>(); }
  public static <K, V> Map<K, V> treeMap() { return new TreeMap<K, V>(); }

  private static long timerT;
  public static void timerStart() {
    timerT = System.currentTimeMillis(); 
  }

  public static long timerStop() {
    return System.currentTimeMillis() - timerT;
  }

  private static Runtime r = Runtime.getRuntime();
  public static long memoryUsage() {
    System.gc();
    return r.totalMemory() - r.freeMemory();
  }

  private static long memoryUsage;
  public static void memoryStart() {
    memoryUsage = memoryUsage();
  }

  public static long memoryStop() {
    return memoryUsage() - memoryUsage;
  }
}