package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 素朴な方法で信号のライトを三つにした例
// 激しく冗長
public class Signals2 extends JFrame {
  private static final long serialVersionUID = -641902875447890690L;

  private class RedListener implements MouseInputListener {
    public void mouseClicked(MouseEvent e) {
      out.println("Red");
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
  }

  private class YellowListener implements MouseInputListener {
    public void mouseClicked(MouseEvent e) {
      out.println("Yellow");
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
  }

  private class GreenListener implements MouseInputListener {
    public void mouseClicked(MouseEvent e) {
      out.println("Green");
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
  }

  private Signals2() {
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
    new Signals2();
  }
}
