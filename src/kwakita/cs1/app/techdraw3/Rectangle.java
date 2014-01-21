package kwakita.cs1.app.techdraw3;

import java.awt.Container;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * @author wakita TechDraw の線分を表すクラスです．
 */
class Rectangle extends Rectangular {
  private Rectangle(List<Point> points) {
    assert points.size() == 2;
    Point p1 = points.get(0), p2 = points.get(1);
    double x = Math.min(p1.x, p2.x), y = Math.min(p1.y, p2.y);
    double w = Math.abs(p1.x - p2.x), h = Math.abs(p1.y - p2.y);
    shape = new Rectangle2D.Double(x, y, w, h);
  }
  
  static final class Factory extends Rectangular.Factory {
    Factory(int x, int y) { super(x, y); }
    Rectangle build() { return new Rectangle(points); }
  }
  
  static final class Tool extends Rectangular.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }
    
    Factory factory(int x, int y) { return new Factory(x, y); }
    
    final class View extends Rectangular.Tool.View {
      private View(Container container) { super("長方形", container); }
    }
    
    final class Control extends Rectangular.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}