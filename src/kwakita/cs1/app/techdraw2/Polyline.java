package kwakita.cs1.app.techdraw2;

import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.LinkedList;
import java.util.List;

class Polyline extends TDShape {
    private Polyline(List<Point> points) {
        Path2D path = new Path2D.Double();
        Point p0 = points.remove(0);
        path.moveTo(p0.getX(), p0.getY());
        for (Point p : points) path.lineTo(p.getX(), p.getY());
        shape = path;
        fill = null;
    }
    
    public boolean select() {
        return shape.intersects(selectionPoint);
    }

    static final class Factory {
        private List<Point> points = new LinkedList<Point>();

        Factory(int x, int y) {
            points.add(new Point(x, y));
        }

        void add(int x, int y) {
            points.add(new Point(x, y));
        }

        Polyline build() {
            return (points.size() >= 2) ? new Polyline(points) : null;
        }
    }
}
