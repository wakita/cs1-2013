package kwakita.cs1.app.techdraw2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class SelectTool extends DrawTool {
    TDCanvas.Model canvasModel = TDCanvas.model;
    
    SelectTool(Container container) {
        new View(container).button().addActionListener(new Control());
    }
    
    class View extends DrawTool.View {
        private View(Container container) {
            super("選択", container);
        }
    }
    
    class Control extends DrawTool.Control {
        final MouseListener selectTool = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                canvasModel.chooseShape(e.getPoint());
            }
        };
        
        public void actionPerformed(ActionEvent e) {
            switchTool(selectTool);
        }
    }
}
