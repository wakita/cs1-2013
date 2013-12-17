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

/**
 * @author wakita GUI を有するアプレットを作成する場合には，JApplet を拡張して作成し，JApplet クラスの init,
 *         start メソッド等を適宜上書きして実装する． init, start の使い方については各メソッドの実装箇所で簡単に触れている．
 * 
 * @see javax.swing.JApplet
 * @see java.applet.Applet
 */
@SuppressWarnings("serial")
public class JPaintApplet extends JApplet {
  private final JComponent canvas = new JComponent() {
  };
  private final JButton clearButton = new JButton("Clear the Canvas");

  /**
   * ここで作成するアプレットとは、ウェブブラウザのなかで動作する Java のプログラムのことをさす。
   * 
   * init メソッドは JApplet が作成されたときに呼び出される． ここでは，GUI 画面の構成をする処理を記述する．
   * 
   * Eclipse からの実行方法は、"Run as Java Applet" で Applet Viewer を起動する。
   * ブラウザに組込むには、アプリケーションのクラスファイル群を Jar パッケージに固めたものを HTML に指定する。
   * 
   * @see java.applet.Applet#init()
   */
  public void init() {
    canvas.setPreferredSize(new Dimension(800, 600));

    Container root = this.getContentPane();
    root.setLayout(new BorderLayout());

    root.add(canvas, BorderLayout.CENTER);
    root.add(clearButton, BorderLayout.NORTH);
  }

  /**
   * このクラスの初期化のときに呼び出される init メソッドに対して，start
   * メソッドはアプレットが画面に表示されるときに呼ばれる．S01JPaintApplication クラスにおいて pack して，GUI
   * 部品の画面への配置が決まるまでグラフィックコンテキストを所得できなかったことを思い出が参考になろう．アプレットは pack
   * メソッドを提供するかわりに，画面が表示されるタイミングで呼ばれる start メソッドを利用する．
   * 
   * この仕様の違いは，画面への表示を完全に制御可能な一般アプリケーションとブラウザのなかでの動作が想定されているアプレットの違いによる． アプレットの場合
   * ，ほかのタブが表示されていて，アプレットが動いているタブが表示されていない場合，スクロール操作でページ内のアプレットが表示されていない場合など
   * ，いろいろな理由からアプレットが無駄に動いてしまうことが想定される．ブラウザの画面表示のような外的な事象を反映した動作が記述できるような仕組みを
   * JApplet クラスは用意している．
   * 
   * start メソッドが呼ばれる時点でようやく適切なグラフィックコンテキストを取得できる．ためしに，以下の start メソッドの内容を init
   * メソッドのなかに移動すると，描画ができなくなる．
   * 
   * @see java.applet.Applet#start()
   */
  public void start() {
    final Graphics g = canvas.getGraphics();

    canvas.addMouseMotionListener(new MouseAdapter() {
      public void mouseDragged(MouseEvent e) {
        g.fillRect(e.getX() - 1, e.getY() - 1, 3, 3);
      }
    });
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
      }
    });
  }
}
