package kwakita.cs1.app.painting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JPaintApplicationA {
    /**
     * 描画対象を表しているグラフィックコンテキスト (g) はマウスドラッグを用いた描画と画面消去でともに利用される．
     * どちらの機能もアダプタを拡張したクラスで実装されている． これらのクラスに対してともにグラフィックコンテキストへのをアクセスを許すために，
     * これらのクラスから共通に見えるスコープでグラフィックコンテキストを宣言する方法を選択した． 別の手法については，このクラスの変種で示す．
     */
    private Graphics g;

    private void run() {
        JFrame frame = new JFrame("JPaint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JComponent canvas = new JComponent() {};
        canvas.setPreferredSize(new Dimension(800, 600));

        /*
         * ドラッグ操作に対応して点描する機能を追加している． このために MouseAdapter を活用している． MouseAdapter
         * クラスは MouseMotionListener インタフェイスを実装する目的で Java が標準的に用意しているアダプタクラスである．
         * 
         * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
         */
        canvas.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                g.fillRect(e.getX() - 1, e.getY() - 1, 3, 3);
            }
        });

        /*
         * これまでの例と同様にウィンドウ (frame) の内容として canvas を追加する． これまでの例と異なり，この例では複数の GUI
         * 部品を追加する． 複数の GUI 部品を追加するときには，それらの部品の配置を司るレイアウトマネージャを設定しなくてはならない．
         * ここでは，アプリケーションの標準的な GUI を構成するために普通に用いられる BorderLayout を用いる．
         * このレイアウトマネージャは画面の領域を東西南北＋中央に五分割し，それぞれに一つずつの GUI 部品を配置できるようにしたものである．
         * 
         * @see java.awt.BorderLayout
         */
        Container root = frame.getContentPane();
        root.setLayout(new BorderLayout());

        // 画面中央に描画領域 (canvas) を配置する．
        root.add(canvas, BorderLayout.CENTER);

        // 画面上部 (= 北/NORTH) に画面消去のためのボタンを配置する．
        JButton clearButton = new JButton("Clear the Canvas");
        root.add(clearButton, BorderLayout. NORTH);

        /*
         * 画面消去の機能をボタンに与えるために ActionListener を実装したクラスのインスタンスを用意しなくてはならない．
         * 描画機能を実装するときには MouseAdapter をアダプタとして用いた．これは MouseMotion
         * が複数のメソッドを要求する，(たいしたことはないけれども)やや複雑なインタフェイスだったからである． これに対して
         * ActionListener インタフェイスは actionPerformed
         * メソッドのみを要求する単純なものなので，ここでは「インタフェイスを拡張」することとした．
         * これまで諸君が学んだ無名クラスは，既存の抽象クラスを拡張する方法で定義していたことと思うが，ここでは抽象クラスではなくインタフェイス
         * (ActionListener)を拡張していることに注目して欲しい．
         * 
         * @see java.awt.event.ActionListener
         * @see javax.swing.AbstractAction
         */
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        });

        frame.pack();
        /* キャンバスのグラフィックコンテキストはキャンバスがフレームに配置されたあと，すなわち pack したあとに初期化されるらしい．
         * 本当ならば，canvas を定義した直後の行に以下の宣言を追加したかった．
         *     final Graphics g = canvas.getGraphics(); 
         * このように final 宣言した変数であれば，このクラスのなかで利用している二つの無名クラスのなかからも参照することができるからだ．
         */
        g = canvas.getGraphics();

        frame.setVisible(true);
    }

    public static void main(String... _) {
        new JPaintApplicationA().run();
    }
}