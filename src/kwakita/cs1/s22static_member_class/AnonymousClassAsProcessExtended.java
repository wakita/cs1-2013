package kwakita.cs1.s22static_member_class;

import static java.lang.System.out;

import javax.swing.JFrame;

public class AnonymousClassAsProcessExtended extends JFrame {
  private static final long serialVersionUID = 1120060173143775204L;

    private void run() {
        final long start = System.currentTimeMillis();
        
        new Thread() {
            public void run() {
                while (true) {
                    long t = System.currentTimeMillis() - start;
                    out.printf("%06d: 生地をこね終ったよ！\n", t);
                    try { sleep(1900); } catch (InterruptedException e) {}
                }
            }
        }.start();
        
        new Thread() {
            public void run() {
                while (true) {
                    long t = System.currentTimeMillis() - start;
                    out.printf("%06d: パンが焼けたよ！\n", t);
                    try { sleep(2900); } catch (InterruptedException e) {}
                }
            }
        }.start();
        
        new Thread() {
            public void run() {
                while (true) {
                    long t = System.currentTimeMillis() - start;
                    out.printf("%06d: パンを届けたよ！\n", t);
                    try { sleep(3700); } catch (InterruptedException e) {}
                }
            }
        }.start();
    }
    
    public static void main(String[] _) {
        new AnonymousClassAsProcessExtended().run();
    }
}
