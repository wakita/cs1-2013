package kwakita.cs1.app.techdraw;

import java.awt.Point;
import java.awt.geom.Path2D;
import java.util.LinkedList;
import java.util.List;

public class Polygon extends TDShape {
    private Polygon(List<Point> points) {
        assert points.size() >= 2;
        
        Path2D.Double path = null;
        for (Point p : points) {
            if (path == null) {
                path = new Path2D.Double();
                path.moveTo(p.x, p.y);
            } else path.lineTo(p.x, p.y);
            path.closePath();
        }
        shape = path;
    }

    static final class Factory {
        private List<Point> points = new LinkedList<Point>();

        Factory(int x, int y) {
            points.add(new Point(x, y));
        }

        void add(int x, int y) {
            points.add(new Point(x, y));
        }

        Polygon build() {
            return new Polygon(points);
        }
    }
}
