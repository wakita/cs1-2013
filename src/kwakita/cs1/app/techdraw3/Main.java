package kwakita.cs1.app.techdraw3;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 * @author wakita
 * TechDraw の大まかな構造を定義しています．
 * TechDraw の機能は，各種のボタンやキャンバスで実装されるため，このレベルでは単にビューを構成するのみです．
 */
public class Main {
  static class View {
    private final JFrame frame = new JFrame("TechDraw");
    private final Container root = frame.getContentPane();
    private final JToolBar toolbar = new JToolBar();

    View() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      root.setLayout(new BorderLayout());

      root.add(TDCanvas.view, BorderLayout.CENTER);
      new Select.Tool(toolbar);
      new Line.Tool(toolbar);
      new Rectangle.Tool(toolbar);
      new RRectangle.Tool(toolbar);
      new Ellipse.Tool(toolbar);
      new Polyline.Tool(toolbar);
      new Curve.Tool(toolbar);
      new Polygon.Tool(toolbar);
      new ColorTool(toolbar);
      new FillTool(toolbar);
      root.add(toolbar, BorderLayout.NORTH);

      frame.pack();
      frame.setVisible(true);
    }
  }

  private void run() {
    new View();
  }

  public static void main(String[] _) {
    new Main().run();
  }
}
