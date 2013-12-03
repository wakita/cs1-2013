package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// non-static member class → static member class
public class Signals9 extends JFrame {
  private static final long serialVersionUID = 1146112863000686336L;

    private static class ColorListener extends MouseInputAdapter {
        String c;
        ColorListener(String c) { this.c = c; }
        public void mouseClicked(MouseEvent e) { out.println(c); }
    }

    private Signals9() {
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
        
        Runtime r = Runtime.getRuntime();
        out.printf("メモリ使用量: %d\n", r.totalMemory() - r.freeMemory());
    }

    public static void main(String[] _) {
        new Signals9();
    }
}
