package kwakita.cs1.app.techdraw3;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

abstract class AbstractColorTool extends MVC {
  AbstractColorTool() { new Model(); }

  class Model extends MVC.Model { protected Color color; }

  abstract class View extends MVC.View {
    private final JButton button;
    JButton button() { return button; }

    protected View(String title, Container container) {
      super();
      button = new JButton(title);
      container.add(button);
    }
  }

  abstract class Control extends MVC.Control implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      AbstractColorTool.Model m = (AbstractColorTool.Model)model;
      m.color = JColorChooser.showDialog(null, ((View)view).button.getText() + "を選んで下さい", m.color);
    }
  }
}

class ColorTool extends AbstractColorTool {
  ColorTool(Container container) {
    super();
    new View(container).button().addActionListener(new Control());
  }

  class View extends AbstractColorTool.View {
    View(Container container) { super("線の色", container); }
  }

  class Control extends AbstractColorTool.Control {
    public void actionPerformed(ActionEvent e) {
      super.actionPerformed(e);
      AbstractColorTool.Model m = (AbstractColorTool.Model)model;
      TDCanvas.model.setColor(m.color);
    }
  }
}

class FillTool extends AbstractColorTool {
  FillTool(Container container) {
    super();
    new View(container).button().addActionListener(new Control());
  }

  class View extends AbstractColorTool.View {
    View(Container container) { super("塗り潰し色", container); }
  }

  class Control extends AbstractColorTool.Control {
    public void actionPerformed(ActionEvent e) {
      super.actionPerformed(e);
      AbstractColorTool.Model m = (AbstractColorTool.Model)model;
      TDCanvas.model.setFill(m.color);
    }
  }
}