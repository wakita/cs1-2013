package kwakita.cs1.app.techdraw2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

abstract class RectangularTool extends DrawTool {
    abstract class Model extends DrawTool.Model {
        
    }
    
    abstract class Control extends DrawTool.Control {
        Rectangular.Factory factory = null;
        
        abstract Rectangular.Factory rectangularFactory(int x, int y);
        
        final MouseListener rectangularTool = new MouseAdapter () {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                if (factory == null) {
                    factory = rectangularFactory(x, y);
                } else {
                    factory.add(x, y);
                    canvasModel.add(factory.build());
                    factory = null;
                }
            }
            
            public void mouseDragged(MouseEvent e) {
                
            }
        };
        
        public void actionPerformed(ActionEvent e) {
            switchTool(rectangularTool);
        }
    }
    
    abstract class View extends DrawTool.View {
        protected View(String title, Container container) {
            super(title, container);
        }
    }
}
