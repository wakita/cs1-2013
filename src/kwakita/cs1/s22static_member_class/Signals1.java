package kwakita.cs1.s22static_member_class;

import static java.lang.System.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 信号の素朴な実装
public class Signals1 extends JFrame {
  private static final long serialVersionUID = 822991150182300993L;

  private class RedListener implements MouseInputListener {
    public void mouseClicked(MouseEvent e) { out.println("Red"); }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
  }

  private Signals1() {
    super("Traffic Signal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();

    JButton red = new JButton("Red");
    red.addMouseListener(new RedListener());
    pane.add(red);

    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] _) {
    new Signals1();
  }
}
