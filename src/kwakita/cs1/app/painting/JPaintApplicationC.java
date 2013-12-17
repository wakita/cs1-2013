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
public class JPaintApplicationC {
    private void run() {
        JFrame frame = new JFrame("JPaint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JComponent canvas = new JComponent() {};
        canvas.setPreferredSize(new Dimension(800, 600));

        Container root = frame.getContentPane();
        root.setLayout(new BorderLayout());

        root.add(canvas, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear the Canvas");
        root.add(clearButton, BorderLayout.NORTH);

        frame.pack();

        /*
         * 二つのリスナーたちに，キャンバスのグラフィックコンテキストを見させる，もうひとつの手段は，
         * それぞれのリスナーの定義のなかでグラフィックコンテキストを宣言する方法である．以下のリスナーたちの定義において，グラフィックコンテキスト
         * (g) は private final 宣言されている．g の宣言が重複する難はあるものの，リスナーの数が少なければ簡単でよいかもしれない．
         */
        canvas.addMouseMotionListener(new MouseAdapter() {
            private final Graphics g = canvas.getGraphics();

            public void mouseDragged(MouseEvent e) {
                g.fillRect(e.getX() - 1, e.getY() - 1, 3, 3);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            private final Graphics g = canvas.getGraphics();

            public void actionPerformed(ActionEvent e) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String... _) {
        new JPaintApplicationC().run();
    }
}
