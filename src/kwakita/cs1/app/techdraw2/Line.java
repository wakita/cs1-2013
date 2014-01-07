package kwakita.cs1.app.techdraw2;

import java.awt.Point;
import java.util.List;

/**
 * @author wakita TechDraw の線分を表すクラスです．
 */
class Line extends Rectangular {
    private Line(List<Point> points) {
        shape = TDShape.Line2D(points);
    }
    
    public boolean select() {
        return shape.intersects(selectionPoint);
    }

    static final class Factory extends Rectangular.Factory {
        Factory(int x, int y) {
            super(x, y);
        }
        
        Line build() {
            return new Line(points);
        }
    }
}
