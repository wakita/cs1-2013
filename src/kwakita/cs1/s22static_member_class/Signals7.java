package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 信号ボタンを作成する箇所の冗長性をループで除去した例
public class Signals7 extends JFrame {
  private static final long serialVersionUID = -4054701229119272492L;

    private class ColorListener extends MouseInputAdapter {
        String c;
        ColorListener(String c) { this.c = c; }
        public void mouseClicked(MouseEvent e) { out.println(c); }
    }

    private Signals7() {
        super("Traffic Signal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        
        for (String c : new String[] { "Red", "Yellow", "Green" }) {
            JButton b = new JButton(c);
            b.addMouseListener(new ColorListener(c));
            pane.add(b);
        }

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] _) {
        new Signals7();
    }
}
