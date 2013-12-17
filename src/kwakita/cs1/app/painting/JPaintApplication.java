package kwakita.cs1.app.painting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author wakita
 * 
 *         JPaintApplet で GUI を持ったアプレットの作り方について学んだ． GUI を持ったアプリケーションの作り方については
 *         JPaintApplication[A-C] で学んだ。
 * 
 *         ここでは，同じプログラムから GUI つきのアプリケーションとしても，アプレットとしても動作するものを作成することができることを示す．
 */
@SuppressWarnings("serial")
public class JPaintApplication extends JApplet {
  private final JComponent canvas = new JComponent() {
  };
  private final JButton clearButton = new JButton("Clear the Canvas");

  /**
   * GUI部品を作成し，画面に追加する処理．アプリケーションからもアプレットからも共通に呼び出される．
   * 
   * @param container
   */
  private void buildGUI(Container container) {
    canvas.setPreferredSize(new Dimension(800, 600));
    container.setLayout(new BorderLayout());
    container.add(canvas, BorderLayout.CENTER);
    container.add(clearButton, BorderLayout.NORTH);
  }

  /**
   * GUI部品に動作を与える処理．アプリケーションからもアプレットからも共通に呼び出される．
   */
  private void addListeners() {
    final Graphics g = canvas.getGraphics();
    /*
     * GUI に動作を与えるときは，しばしば，いくつかのアダプタを利用して，無名クラスを作成する． 以下では，マウスの動作を記述するために
     * MouseAdapter を拡張した無名クラスの利用例．
     */
    canvas.addMouseMotionListener(new MouseAdapter() {
      public void mouseDragged(MouseEvent e) {
        g.fillRect(e.getX() - 1, e.getY() - 1, 3, 3);
      }
    });
    /*
     * ActionListenerに対応したアダプタは存在しないが，このインタフェイスはactionPerformしか
     * 定義していないので，アダプタを使うまでもなく，インタフェイスを単純に拡張して無名クラスを作成している．
     */
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
      }
    });
  }

  /**
   * アプレットのために用意した initメソッド．
   * 
   * @see java.applet.Applet#init()
   */
  public void init() {
    buildGUI(this);
  }

  /**
   * アプレットのために用意した start メソッド．
   * 
   * @see java.applet.Applet#start()
   */
  public void start() {
    addListeners();
  }

  /**
   * アプリケーションの main メソッドから呼び出される処理．GUI 部品の画面への配置を行う処理 (pack) 処理を挟んで，GUI
   * 部品の追加処理とGUI部品の動作を与える処理をする．
   */
  private void run() {
    JFrame frame = new JFrame("JPaint Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buildGUI(frame.getContentPane());
    frame.pack();
    addListeners();
    frame.setVisible(true);
  }

  public static void main(String[] _) {
    new JPaintApplication().run();
  }
}
