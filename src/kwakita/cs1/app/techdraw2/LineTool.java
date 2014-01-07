package kwakita.cs1.app.techdraw2;

import java.awt.Container;

/**
 * @author wakita 線分ボタンに関わる機能を MVC モデルに準じて一括して実装しています．
 */
class LineTool extends RectangularTool {
    LineTool(Container container) {
        View view = new View(container);
        Control control = new Control();
        view.button().addActionListener(control);
        view.button().doClick();
    }
    
    class Model extends DrawTool.Model {
        Model() {
            shape = new Line.Factory(0, 0).add(0, 0).build();
        }
    }

    class View extends RectangularTool.View {
        protected View(Container container) {
            super("線分", container);
        }
    }

    class Control extends RectangularTool.Control {
        Rectangular.Factory rectangularFactory(int x, int y) {
            return new Line.Factory(x, y);
        }
    }
}
