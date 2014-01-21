package kwakita.cs1.app.techdraw3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.List;

class Curve extends Points {
  private Curve(List<Point> points) {
    Path2D path = new Path2D.Double();
    Point p0 = points.remove(0);
    path.moveTo(p0.x, p0.y);
    for (int i = 1; i+1 < points.size(); i+=2) {
      Point p1 = points.get(i), p2 = points.get(i+1);
      path.quadTo(p1.x, p1.y, p2.x, p2.y);
    }
    /*
    for (int i = 0; i+2 < points.size(); i+=2) {
      Point p1 = points.get(i), p2 = points.get(i+1), p3 = points.get(i+2);
      path.curveTo(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    }
    */
    shape = path;
    fill = null;
  }
  
  public void fill(Graphics2D g, Color fill) { }

  public boolean select() { return shape.intersects(selectionPoint); }

  static final class Factory extends Points.Factory {
    Factory(int x, int y) { super(x, y); }

    Curve build() {
      return (points.size() >= 2) ? new Curve(points) : null;
    }
  }

  static final class Tool extends Points.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }
    
    Factory factory(int x, int y) { return new Factory(x, y); }

    final class View extends Points.Tool.View {
      private View(Container container) { super("曲線", container); }
    }

    final class Control extends Points.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}
