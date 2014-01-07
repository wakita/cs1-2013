package kwakita.cs1.app.techdraw2;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

abstract class DrawTool extends MVC {
    TDCanvas.Model canvasModel = TDCanvas.model;

    protected static final ButtonGroup radioGroup = new ButtonGroup();
    
    abstract class Model extends MVC.Model {
        protected TDShape shape;
    }
    
    abstract class View extends MVC.View {
        private final AbstractButton button;
        
        AbstractButton button() {
            return button;
        }
        
        protected View(String title, Container container) {
            super();
            button = new JRadioButton(title);
            radioGroup.add(button);
            container.add(button);
        }
    }
    
    abstract class Control extends MVC.Control implements ActionListener {
        protected TDCanvas.View canvas = TDCanvas.view;
        
        void switchTool(MouseListener tool) {
            TDCanvas.control.switchTool(tool);
        }
    }
}
