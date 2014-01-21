package kwakita.cs1.app.techdraw3;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.RectangularShape;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

abstract class Rectangular extends TDShape {
  void move(int dx, int dy) {
    RectangularShape s = (RectangularShape)shape;
    s.setFrame(s.getX() + dx, s.getY() + dy, s.getWidth(), s.getHeight());
  }
  
  static abstract class Tool extends TDShape.Tool {
    abstract class Control extends TDShape.Tool.Control {
      final MouseInputListener tool = new MouseInputAdapter() {
        public void mouseClicked(MouseEvent e) {
          int x = e.getX(), y = e.getY();
          if (factory == null) factory = factory(x, y);
          else {
            factory.add(x, y);
            canvasModel.add(factory.build());
            reset();
          }
        }
      };
        
      public void actionPerformed(ActionEvent e) { switchTool(tool); }
    }
  }
}