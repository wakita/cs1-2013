package kwakita.cs1.app.techdraw3;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

class TDCanvas {
  static Model model = new Model();
  static View view = new View(800, 600);
  static Control control = new Control();

  static class Model {
    private static final Color EDIT_SHAPE_COLOR = Color.BLUE;
    private static final Stroke EDIT_STROKE = new BasicStroke(1);

    private Color color = TDShape.DEFAULT_COLOR, fill = TDShape.DEFAULT_FILL;
    void setColor(Color color) {
      this.color = color;
      if (shape != null) shape.color = color;
      view.update();
    }
    void setFill(Color fill) {
      this.fill = fill;
      if (shape != null) shape.fill = fill;
      view.update();
    }

    TDShape shape = null;

    void chooseShape(Point p) {
      TDShape.selectPoint(p);
      shape = null;
      for (int i = shapes.size() - 1; i >= 0; i--) {
        TDShape s = shapes.get(i);
        if (s.select()) {
          shape = s;
          break;
        }
      }
      view.repaint();
    }

    private static final List<TDShape> shapes = new LinkedList<TDShape>();

    List<TDShape> shapes() {
      return Collections.unmodifiableList(shapes);
    }

    void add(TDShape shape) {
      shape.setColor(color, fill);
      shapes.add(shape);
      shape = null;
      view.update();
    }
  }

  @SuppressWarnings("serial")
  static class View extends JComponent {
    List<TDShape> shapes;

    View(int h, int w) {
      view = this;
      this.setPreferredSize(new Dimension(h, w));
      shapes = model.shapes();
    }

    public void paintComponent(Graphics graphics) {
      Graphics2D g = (Graphics2D) graphics;
      g.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

      for (TDShape shape : shapes) {
        shape.fill(g);
        shape.draw(g);
      }

      if (model.shape != null) {
        model.shape.draw(g, Model.EDIT_SHAPE_COLOR, Model.EDIT_STROKE);
      }
    }

    void update() { repaint(); }
  }

  static class Control {
    private MouseInputListener mouseTool = null;

    void switchTool(MouseInputListener newTool) {
      if (mouseTool != null) {
        view.removeMouseListener(mouseTool);
        view.removeMouseMotionListener(mouseTool);
      }
      view.addMouseListener(newTool);
      view.addMouseMotionListener(newTool);
      mouseTool = newTool;
      model.shape = null;
    }
  }
}
