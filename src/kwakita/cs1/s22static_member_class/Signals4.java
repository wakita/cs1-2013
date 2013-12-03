package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 実は同様の抽象クラス (MouseInputAdapter)が Java の標準的な API にあるので、わざわざ自分で作ることはなかったのだ。
public class Signals4 extends JFrame {
  private static final long serialVersionUID = -5868477921728684212L;

  private class RedListener extends MouseInputAdapter {
    public void mouseClicked(MouseEvent e) { out.println("Red"); }
  }

  private class YellowListener extends MouseInputAdapter {
    public void mouseClicked(MouseEvent e) { out.println("Yellow"); }
  }

  private class GreenListener extends MouseInputAdapter {
    public void mouseClicked(MouseEvent e) { out.println("Green"); }
  }

  private Signals4() {
    super("Traffic Signal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();
    pane.setLayout(new FlowLayout());

    JButton red = new JButton("Red");
    red.addMouseListener(new RedListener());
    pane.add(red);

    JButton yellow = new JButton("Yellow");
    yellow.addMouseListener(new YellowListener());
    pane.add(yellow);

    JButton green = new JButton("Green");
    green.addMouseListener(new GreenListener());
    pane.add(green);

    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] _) {
    new Signals4();
  }
}
