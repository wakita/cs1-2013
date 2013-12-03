package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 抽象クラス (AbstractMouseInputListener) を作って空メソッドの定義を除去した例
public class Signals3 extends JFrame {
  private static final long serialVersionUID = 3444397978779715681L;

  private abstract class AbstractMouseInputListener implements MouseInputListener {
    public void mouseClicked(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
  }

  private class RedListener extends AbstractMouseInputListener {
    public void mouseClicked(MouseEvent e) { out.println("Red"); }
  }

  private class YellowListener extends AbstractMouseInputListener {
    public void mouseClicked(MouseEvent e) { out.println("Yellow"); }
  }

  private class GreenListener extends AbstractMouseInputListener {
    public void mouseClicked(MouseEvent e) { out.println("Green"); }
  }

  private Signals3() {
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
    new Signals3();
  }
}
