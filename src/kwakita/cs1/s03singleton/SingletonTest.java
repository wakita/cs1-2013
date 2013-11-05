package kwakita.cs1.s03singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wakita
 * 7種類の Singleton クラスの実装がそれぞれ適切に serialize 操作に対応しているか否かを判定するテスト
 */
public class SingletonTest {

  /**
   * serialize (正順化ともいう)とは，与えられたオブジェクトをファイルやデータベースに保存したり，
   * 遠隔ノードに送信するなどの目的からデータ列に変換する操作．
   * @param obj 正順化したいオブジェクト
   * @return 正順化した結果のバイト列
   * @throws IOException
   */
  private static byte[] serialize(Object obj) throws IOException {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bout);
    out.writeObject(obj);
    out.close();
    bout.close();
    return bout.toByteArray();
  }

  /**
   * serialize とは逆に，正順化操作によって変換された形式から元のオブジェクトを復旧するための操作を unserialize という．
   * @param data 正順化されたオブジェクトのデータ
   * @return unserialize 操作によって復旧されたオブジェクト
   * @throws IOException
   * @throws ClassNotFoundException
   */
  private static Object unserialize(byte[] data) throws IOException,
  ClassNotFoundException {
    ByteArrayInputStream bin = new ByteArrayInputStream(data);
    ObjectInputStream in = new ObjectInputStream(bin);
    Object obj = in.readObject();
    in.close();
    bin.close();
    return obj;
  }

  private void test(String message, Singleton s1) {
    try {
      Singleton s2 = (Singleton) unserialize(serialize(s1));
      if (s1 != s2) {
        System.out.printf("%s: シリアライズをしたら私の複製ができてしまいました。\n", message);
      } else {
        System.out.printf("%s: シリアライズに対して頑健です。\n", message);
      }
    } catch (NotSerializableException e) {
      System.out.printf("%s: シリアライズに対応していないようです。\n\t%s\n", message, e);
    } catch (Exception e) {
      System.out.printf("%s: シリアライズの最終になにやらわけのわからない例外が発生しました．\n\t%s\n", message, e);
    }
    System.out.println();
  }

  private void run() {
    test("Singleton1", Singleton1.INSTANCE);
    test("Singleton1a", Singleton1a.INSTANCE);
    test("Singleton1b", Singleton1b.INSTANCE);
    test("Singleton2", Singleton2.getInstance());
    test("Singleton2a", Singleton2a.getInstance());
    test("Singleton2b", Singleton2b.getInstance());
    test("Singleton3", Singleton3.INSTANCE);
  }

  public static void main(String... _) {
    new SingletonTest().run();
  }

}
