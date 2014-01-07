package kwakita.cs1.app.techdraw2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * @author wakita
 * TechDraw が扱う図形一般を表現する抽象クラスです．このクラスを充実させることで TechDraw の機能拡張ができます．
 */
abstract class TDShape {
    protected Shape shape;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    public static final Color DEFAULT_FILL  = Color.GRAY;
    public static final Stroke DEFAULT_STROKE = new BasicStroke(2);

    Color color = DEFAULT_COLOR, fill = DEFAULT_FILL;
    Stroke stroke = DEFAULT_STROKE;
    
    static final Rectangle2D selectionPoint = new Rectangle2D.Double(0, 0, 2, 2);
    static void selectPoint(Point p) {
        selectionPoint.setFrameFromCenter(p.x, p.y, p.x + 2, p.y + 2);
    }
    
    public void setColor(Color color, Color fill) {
        this.color = color;
        this.fill = fill;
    }

    public void fill(Graphics2D g, Color color, Color fill, Stroke stroke) {
        if (this.fill != null && fill != null) {
            g.setColor(fill);
            g.fill(shape);
        }
        if (this.color != null && color != null) {
            g.setColor(color);
            g.setStroke(stroke != null ? stroke : DEFAULT_STROKE);
            g.draw(shape);
        }
    }
    
    public void draw(Graphics2D g) {
        fill(g, color, null, stroke);
    }
    
    public void fill(Graphics2D g) {
        fill(g, color, fill, stroke);
    }
    
    public boolean select() {
        return shape.contains(selectionPoint);
    }
    
    public static Line2D Line2D(List<Point> points) {
        assert points.size() == 2;
        return new Line2D.Double(points.get(0), points.get(1));
    }
    
    public static Rectangle2D Rectangle2D(List<Point> points) {
        assert points.size() == 2;
        Point p1 = points.get(0), p2 = points.get(1);
        double x = Math.min(p1.x, p2.x), y = Math.min(p1.y, p2.y);
        double w = Math.abs(p1.x - p2.x), h = Math.abs(p1.y - p2.y);
        return new Rectangle2D.Double(x, y, w, h);
    }
}
