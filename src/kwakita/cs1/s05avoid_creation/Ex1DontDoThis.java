package kwakita.cs1.s05avoid_creation;

/**
 * @author wakita
 * 初心者にありがちな非効率なプログラム例
 */
public class Ex1DontDoThis {
  // 定数(immutable)オブジェクトを複製するのはメモリーの無駄だ。
  public String これだけはやめて下さい(String foo) {
    return new String(foo);
  }

  public String 単にこうすればいいのです(String foo) {
    return foo;
  }

  private void run() {
    String s = "なにかいいかげんな文字列";
    System.out.println(これだけはやめて下さい(s));
    System.out.println();
    System.out.println(単にこうすればいいのです(s));
  }

  public static void main(String[] _) {
    new Ex1DontDoThis().run();
  }
}
