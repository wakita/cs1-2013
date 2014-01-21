package kwakita.cs1.app.techdraw3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.List;

class Polyline extends Points {
  private Polyline(List<Point> points) {
    Path2D path = new Path2D.Double();
    Point p0 = points.remove(0);
    path.moveTo(p0.getX(), p0.getY());
    for (Point p : points) path.lineTo(p.getX(), p.getY());
    shape = path;
    fill = null;
  }

  public void fill(Graphics2D g, Color fill) { }

  public boolean select() { return shape.intersects(selectionPoint); }

  static final class Factory extends Points.Factory {
    Factory(int x, int y) { super(x, y); }

    Polyline build() {
      return (points.size() >= 2) ? new Polyline(points) : null;
    }
  }

  static final class Tool extends Points.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }
    
    Factory factory(int x, int y) { return new Factory(x, y); }

    final class View extends Points.Tool.View {
      private View(Container container) { super("折れ線", container); }
    }

    final class Control extends Points.Tool.Control {
      Factory factory(int x, int y) { return new Factory(x, y); }
    }
  }
}
