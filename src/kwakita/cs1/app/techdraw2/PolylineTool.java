package kwakita.cs1.app.techdraw2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class PolylineTool extends DrawTool {
    PolylineTool(Container container) {
        new View(container).button().addActionListener(new Control());
    }
    
    class View extends DrawTool.View {
        private View(Container container) {
            super("折れ線", container);
        }
    }
   
    class Control extends DrawTool.Control {
        Polyline.Factory factory = null;
        
        final MouseListener polylineTool = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                if (factory == null) factory = new Polyline.Factory(x, y);
                else {
                    switch (e.getClickCount()) {
                    case 1:
                        factory.add(x, y);
                        break;
                    case 2:
                        TDShape s = factory.build();
                        if (s != null) {
                            canvasModel.add(s);
                            factory = null;
                        }
                        break;
                    }
                }
            }
        };
        
        public void actionPerformed(ActionEvent e) {
            switchTool(polylineTool);
        }
    }
}
