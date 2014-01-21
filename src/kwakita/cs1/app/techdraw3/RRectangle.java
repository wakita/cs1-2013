package kwakita.cs1.app.techdraw3;

import java.awt.Container;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

/**
 * @author wakita TechDraw の線分を表すクラスです．
 */
class RRectangle extends Rectangular {
  private RRectangle(List<Point> points) {
    assert points.size() == 2;
    Point p1 = points.get(0), p2 = points.get(1);
    double x = Math.min(p1.x, p2.x), y = Math.min(p1.y, p2.y);
    double w = Math.abs(p1.x - p2.x), h = Math.abs(p1.y - p2.y);
    int arc = Math.min(10, Math.min((int)w/2, (int)h/2));
    shape = new RoundRectangle2D.Double(x, y, w, h, arc, arc);
  }
  
  static final class Factory extends Rectangular.Factory {
    Factory(int x, int y) { super(x, y); }
    RRectangle build() { return new RRectangle(points); }
  }
  
  static final class Tool extends Rectangular.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }
    
    Factory factory(int x, int y) { return new Factory(x, y); }
    
    final class View extends Rectangular.Tool.View {
      private View(Container container) { super("角丸長方形", container); }
    }
    
    final class Control extends Rectangular.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}