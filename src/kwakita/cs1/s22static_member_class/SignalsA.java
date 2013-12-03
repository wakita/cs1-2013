package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import kwakita.cs1.U;

// non-static member class のメモリ使用量を測定
public class SignalsA extends JFrame {
  private static final long serialVersionUID = -1336112662728685490L;

    private class ColorListener extends MouseInputAdapter {
        String c;
        ColorListener(String c) { this.c = c; }
        public void mouseClicked(MouseEvent e) { out.println(c); }
    }

    private SignalsA() {
        super("Traffic Signal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(16, 16));

        U.memoryStart();
        for (int r = 0; r < 256; r += 16) {
            for (int b = 0; b < 256; b += 16) {
                int g = 0x00;
                JButton button = new JButton("★");
                button.setForeground(new Color(r, g, b));
                button.addMouseListener(new ColorListener(String.format("RGB=(%d,%d,%d)", r, g, b)));
                pane.add(button);
            }
            out.printf("メモリ使用量: %d\n", U.memoryStop());
        }
        out.printf("ボタン一個あたりのメモリ使用量: %d\n", U.memoryStop() / 256);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] _) {
        new SignalsA();
    }
}
