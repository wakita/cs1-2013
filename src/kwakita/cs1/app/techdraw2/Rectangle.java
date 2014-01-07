package kwakita.cs1.app.techdraw2;

import java.awt.Point;
import java.util.List;

/**
 * @author wakita TechDraw の線分を表すクラスです．
 */
class Rectangle extends Rectangular {
    private Rectangle(List<Point> points) {
        shape = TDShape.Rectangle2D(points);
    }

    static final class Factory extends Rectangular.Factory {
        Factory(int x, int y) {
            super(x, y);
        }
        
        Rectangle build() {
            return new Rectangle(points);
        }
    }
}
