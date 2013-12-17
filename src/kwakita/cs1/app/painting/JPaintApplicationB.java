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
public class JPaintApplicationB {
    private void run() {
        JFrame frame = new JFrame("JPaint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JComponent canvas = new JComponent() {
        };
        canvas.setPreferredSize(new Dimension(800, 600));

        Container root = frame.getContentPane();
        root.setLayout(new BorderLayout());

        root.add(canvas, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear the Canvas");
        root.add(clearButton, BorderLayout.NORTH);

        frame.pack();

        /*
         * JPaintApplicaitonA クラスは，グラフィックコンテキスト (g) を private
         * なフィールドとして宣言し，pack を起動した直後に初期化していた．このため， (1)
         * 変数の宣言と初期化の場所が散在しプログラムが読みにくい (2) 同様の扱いをしたい canvas
         * 変数と異なる宣言方式を用いなくてはならない などの点でプログラムとして汚なかった．
         * 
         * ここでは，pack 後に canvas 変数と同様にメソッド内で final 宣言することとした． この変更に伴って g を利用する
         * Listener たちの定義もここに移動した． 結果として pack より前には GUI の構造の構成，pack より後ろには
         * Listener たちの定義というように分割したと見做せる．
         * 
         * g は二つの Listener たち以外から参照される可能性はない．そのため，g の宣言，二つの Listener たちの追加の処理は {
         * ... } で囲い，局所環境を構成している．これは，Effective Java 45 節 (Minimizing the scope
         * of local variables) の教えに沿ったものである．
         */
        {
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

        /*
         * フレームを画面に表示するタイミングはリスナーを定義したあとにすべきである．リスナーの定義が完了する前に表示された画面を操作して，
         * 何も反応がないような事故は避けるべきだからだ．
         */
        frame.setVisible(true);
    }

    public static void main(String... _) {
        new JPaintApplicationB().run();
    }
}
