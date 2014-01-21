package kwakita.cs1.app.techdraw3;

import java.awt.Container;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.List;

class Polygon extends Points {
  private Polygon(List<Point> points) {
    Path2D path = new Path2D.Double();
    Point p0 = points.remove(0);
    path.moveTo(p0.getX(), p0.getY());
    for (Point p : points) path.lineTo(p.getX(), p.getY());
    path.closePath();
    shape = path;
  }
  
  static final class Factory extends TDShape.Factory {
    Factory(int x, int y) { super(x, y); }
    Points build() {
      return (points.size() >= 2) ? new Polygon(points) : null;
    }
  }
  
  static final class Tool extends Points.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }

    Factory factory(int x, int y) { return new Factory(x, y); }
    
    final class View extends Points.Tool.View {
      private View(Container container) { super("多角形", container); }
    }
    
    final class Control extends Points.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}