package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 内部クラスのメソッド定義に冗長性が残ってたので再び仮想クラス (ColorListener) を作って除去した例
public class Signals6 extends JFrame {
  private static final long serialVersionUID = 248977948349202970L;

    private class ColorListener extends MouseInputAdapter {
        String c;
        ColorListener(String c) { this.c = c; }
        public void mouseClicked(MouseEvent e) { out.println(c); }
    }

    private Signals6() {
        super("Traffic Signal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());

        JButton red = new JButton("Red");
        red.addMouseListener(new ColorListener("Red"));
        pane.add(red);

        JButton yellow = new JButton("Yellow");
        yellow.addMouseListener(new ColorListener("Yellow"));
        pane.add(yellow);

        JButton green = new JButton("Green");
        green.addMouseListener(new ColorListener("Green"));
        pane.add(green);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] _) {
        new Signals6();
    }
}
