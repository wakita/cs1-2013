package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 抽象クラス (ColorListener) を内部クラスではなく、局所クラスで実装した例
// 簡潔な記述になったが細かい制約が多いので注意を要する
// ※1: final class Color Listener
// ※2: final String color = c
public class Signals8 extends JFrame {
  private static final long serialVersionUID = 3660072365328660776L;

    private Signals8() {
        super("Traffic Signal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        
        for (String c : new String[] { "Red", "Yellow", "Green" }) {
            final String color = c;
            final class ColorListener extends MouseInputAdapter {
                public void mouseClicked(MouseEvent e) { out.println(color); }
            }
            JButton b = new JButton(c);
            b.addMouseListener(new ColorListener());
            pane.add(b);
        }

        this.pack();
        this.setVisible(true);
        
        Runtime r = Runtime.getRuntime();
        out.printf("メモリ使用量: %d\n", r.totalMemory() - r.freeMemory());
    }

    public static void main(String[] _) {
        new Signals8();
    }
}
