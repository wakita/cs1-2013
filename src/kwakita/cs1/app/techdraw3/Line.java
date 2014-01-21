package kwakita.cs1.app.techdraw3;

import java.awt.Container;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author wakita TechDraw の線分を表すクラスです．
 */
class Line extends Rectangular {
  private Line(List<Point> points) {
    assert points.size() == 2;
    shape = new Line2D.Double(points.get(0), points.get(1));
  }
  
  void move(int dx, int dy) {
    Line2D line = (Line2D)shape;
    Point2D p1 = line.getP1(), p2 = line.getP2();
    line.setLine(p1.getX() + dx, p1.getY() + dy, p2.getX() + dx, p2.getY() + dy);
  }

  public boolean select() {
    return shape.intersects(selectionPoint);
  }

  static final class Factory extends Rectangular.Factory {
    Factory(int x, int y) { super(x, y); }
    Line build() { return new Line(points); }
  }
  
  static final class Tool extends Rectangular.Tool {
    Tool(Container container) {
      new View(container).button().addActionListener(new Control());
    }
    
    Factory factory(int x, int y) { return new Factory(x, y); }
    
    class View extends Rectangular.Tool.View {
      private View(Container container) { super("線分", container); }
    }
    
    class Control extends Rectangular.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}