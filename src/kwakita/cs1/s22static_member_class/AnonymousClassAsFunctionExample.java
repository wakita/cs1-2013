package kwakita.cs1.s22static_member_class;

import java.awt.Container;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

// 信号の素朴な実装
public class AnonymousClassAsFunctionExample extends JFrame {
  private static final long serialVersionUID = -6267593670302002961L;

  private AnonymousClassAsFunctionExample() {
    super("Traffic Signal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();

    JButton b = new JButton("ここを押して");
    b.addMouseListener(new MouseInputAdapter() {
      public void mouseClicked(MouseEvent e) {
        System.out.println("こんにちは");
      }
    });
    pane.add(b);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] _) {
    new AnonymousClassAsFunctionExample();
  }
}
