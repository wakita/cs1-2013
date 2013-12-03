package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 前述のクラスのかわりにAnonymousクラスを用いた例
public class Signals5 extends JFrame {
  private static final long serialVersionUID = 7746512104630208392L;

  private Signals5() {
    super("Traffic Signal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();
    pane.setLayout(new FlowLayout());

    JButton red = new JButton("Red");
    red.addMouseListener(new MouseInputAdapter() {
      public void mouseClicked(MouseEvent e) { out.println("Red"); }
    });
    pane.add(red);

    JButton yellow = new JButton("Yellow");
    yellow.addMouseListener(new MouseInputAdapter() {
      public void mouseClicked(MouseEvent e) { out.println("Yellow"); }
    });
    pane.add(yellow);

    JButton green = new JButton("Green");
    green.addMouseListener(new MouseInputAdapter() {
      public void mouseClicked(MouseEvent e) { out.println("Green"); }
    });
    pane.add(green);

    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] _) {
    new Signals5();
  }
}
