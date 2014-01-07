package kwakita.cs1.app.techdraw2;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

class TDCanvas {
    static Model model = new Model();
    static View view = new View(800, 600);
    static Control control = new Control();
    
    static class Model {
        private static final Color EDIT_SHAPE_COLOR = Color.BLUE;
        private static final Color EDIT_SHAPE_FILL = Color.lightGray;
        private static final Stroke EDIT_STROKE = new BasicStroke(2);
        
        private Color color = TDShape.DEFAULT_COLOR, fill = TDShape.DEFAULT_FILL;
        void setColor(Color color) {
            this.color = color;
            if (shape != null) shape.color = color;
        }
        void setFill(Color fill) {
            this.fill = fill;
            if (shape != null) shape.fill = fill;
        }
        
        private TDShape shape = null;
        void reselectShape(TDShape s) {
            shape = s;
        }
        
        void chooseShape(Point p) {
            TDShape.selectPoint(p);
            shape = null;
            for (int i = shapes.size() - 1; i >= 0; i--) {
                TDShape s = shapes.get(i);
                if (s.select()) {
                    reselectShape(s);
                    view.repaint();
                    break;
                }
            }
        }
        
        private static final List<TDShape> shapes = new LinkedList<TDShape>();
        
        List<TDShape> shapes() {
            return Collections.unmodifiableList(shapes);
        }
        
        void add(TDShape shape) {
            shape.setColor(color, fill);
            shapes.add(shape);
            shape = null;
            view.update();
        }
    }
    
    @SuppressWarnings("serial")
    static class View extends JComponent {
        List<TDShape> shapes;
        
        View(int h, int w) {
            view = this;
            this.setPreferredSize(new Dimension(h, w));
            shapes = model.shapes();
        }
        
        public void paintComponent(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
            g.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

            for (TDShape shape : shapes) {
                shape.fill(g);
            }
            
            if (model.shape != null) {
                model.shape.fill(g, Model.EDIT_SHAPE_COLOR, Model.EDIT_SHAPE_FILL, Model.EDIT_STROKE);
            }
        }
        
        void update() {
            repaint();
        }
    }
    
    static class Control {
        private MouseListener currentTool = null;
        
        void switchTool(MouseListener newTool) {
            if (this.currentTool != null) view.removeMouseListener(currentTool);
            view.addMouseListener(newTool);
            currentTool = newTool;
            model.shape = null;
        }
    }
}
