package kwakita.cs1.app.techdraw2;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

abstract class Rectangular extends TDShape {
    static abstract class Factory {
        protected List<Point> points = new LinkedList<Point>();
        
        protected Factory(int x, int y) {
            points.add(new Point(x, y));
        }
        
        Factory add(int x, int y) {
            points.add(new Point(x, y));
            return this;
        }
        
        abstract Rectangular build();
    }
}
