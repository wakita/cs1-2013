package kwakita.cs1.app.techdraw;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Polyline extends TDShape {
    private Polyline(List<Point> points) {
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
            return new Polyline(points);
        }
    }
}
