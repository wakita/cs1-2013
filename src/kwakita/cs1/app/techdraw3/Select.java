package kwakita.cs1.app.techdraw3;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

class Select extends TDShape {
  void move(int dx, int dy) {};
  
  static class Tool extends TDShape.Tool {
    Tool(Container container) { connect(new View(container), new Control()); }
    
    final class View extends TDShape.Tool.View {
      private View(Container container) {
        super("選択", container);
      }
    }

    final class Control extends TDShape.Tool.Control {
      protected void reset() {}

      final MouseInputListener tool = new MouseInputAdapter() {
        Point p0 = null;

        public void mouseClicked(MouseEvent e) {
          TDCanvas.model.chooseShape(p0);
        }
        
        public void mousePressed(MouseEvent e) { p0 = e.getPoint(); }
        
        public void mouseDragged(MouseEvent e) {
          Point p1 = e.getPoint();
          TDShape shape = TDCanvas.model.shape;
          if (shape != null) {
            shape.move(p1.x - p0.x, p1.y - p0.y);
            TDCanvas.view.update();
          }
          p0 = p1;
        }
      };
      
      public void actionPerformed(ActionEvent e) { switchTool(tool); }
    }

    Factory factory(int x, int y) { return null; }
  }
}
