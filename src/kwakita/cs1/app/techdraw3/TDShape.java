package kwakita.cs1.app.techdraw3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.event.MouseInputListener;

/**
 * @author wakita
 * TechDraw が扱う図形一般を表現する抽象クラスです．このクラスを充実させることで TechDraw の機能拡張ができます．
 */
abstract class TDShape {
  protected Shape shape;
  public static final Color DEFAULT_COLOR = Color.BLACK;
  public static final Color DEFAULT_FILL  = null;
  public static final Stroke DEFAULT_STROKE = new BasicStroke(2);
  Color color = DEFAULT_COLOR, fill = DEFAULT_FILL;
  Stroke stroke = DEFAULT_STROKE;

  abstract void move(int dx, int dy);
  
  static final Rectangle2D selectionPoint = new Rectangle2D.Double(0, 0, 2, 2);
  static void selectPoint(Point p) {
    selectionPoint.setFrameFromCenter(p.x, p.y, p.x + 2, p.y + 2);
  }

  public void setColor(Color color, Color fill) {
    this.color = color;
    this.fill = fill;
  }
  
  public void fill(Graphics2D g, Color fill) {
    fill = fill == null ? this.fill : fill;
    if (fill == null) return;
    g.setColor(fill);
    g.fill(shape);
  }
  
  public void draw(Graphics2D g, Color color, Stroke stroke) {
    color = color == null ? this.color : color;
    if (color == null) return;
    g.setColor(color);
    g.setStroke(stroke = stroke == null ? DEFAULT_STROKE : stroke);
    g.draw(shape);
  }
  
  public void fill(Graphics2D g) { fill(g, fill);  }
  public void draw(Graphics2D g) { draw(g, color, stroke); }

  public boolean select() { return shape.contains(selectionPoint); }

  static abstract class Factory {
    protected List<Point> points = new LinkedList<Point>();
    protected Factory(int x, int y) { add(x, y); }
    void add(int x, int y) { points.add(new Point(x, y)); }
    
    abstract TDShape build();
  }

  static abstract class Tool extends MVC {
    TDCanvas.Model canvasModel = TDCanvas.model;

    protected static final ButtonGroup radioGroup = new ButtonGroup();

    Factory factory;
    abstract Factory factory(int x, int y);
    abstract class Model extends MVC.Model { protected TDShape shape; }

    abstract class View extends MVC.View {
      private final AbstractButton button;
      AbstractButton button() { return button; };
      
      protected View(String title, Container container) {
        super();
        button = new JRadioButton(title);
        radioGroup.add(button);
        container.add(button);
      }
    }

    abstract class Control extends MVC.Control implements ActionListener {
      protected TDCanvas.View convas = TDCanvas.view;

      protected void reset() { factory = null; }

      void switchTool(MouseInputListener tool) {
        reset();
        TDCanvas.control.switchTool(tool);
      }
    }
    
    protected void connect(View v, Control c) {
      v.button().addActionListener(c);
    }
  }
}