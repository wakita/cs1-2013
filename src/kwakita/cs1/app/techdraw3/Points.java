package kwakita.cs1.app.techdraw3;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

abstract class Points extends TDShape {
  
  void move(int dx, int dy) {
    Path2D s = (Path2D)shape;
    s.transform(AffineTransform.getTranslateInstance(dx, dy));
  }

  static abstract class Tool extends TDShape.Tool {
    abstract class Control extends TDShape.Tool.Control {
      final MouseInputListener tool = new MouseInputAdapter() {
        public void mouseClicked(MouseEvent e) {
          int x = e.getX(), y = e.getY();
          if (factory == null) factory = factory(x, y);
          else {
            switch (e.getClickCount()) {
              case 1: factory.add(x, y); break;
              case 2:
                TDShape s = factory.build();
                if (s != null) {
                  canvasModel.add(s);
                  reset();
                }
                break;
            }
          }
        }
      };

      public void actionPerformed(ActionEvent e) { switchTool(tool); }
    }
  }
}