package kwakita.cs1.s22static_member_class;

import static java.lang.System.out;

import javax.swing.JFrame;

public class AnonymousClassAsProcessExample extends JFrame {
  private static final long serialVersionUID = 1120060173143775204L;

  private void run() {
    new Thread() {  // スレッド：並列実行を表現するオブジェクト
      public void run() {
        while (true) {
          out.println("生地ができたよ！");
          try { sleep(1900); } catch (InterruptedException e) {}
        }
      }
    }.start();

    new Thread() {  // もうひとつスレッドを用意して2並列
      public void run() {
        while (true) {
          out.println("パンが焼けたよ！");
          try { sleep(2900); } catch (InterruptedException e) {}
        }
      }
    }.start();
  }

  public static void main(String[] _) {
    new AnonymousClassAsProcessExample().run();
  }
}