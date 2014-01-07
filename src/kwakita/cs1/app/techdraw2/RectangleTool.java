package kwakita.cs1.app.techdraw2;

import java.awt.Container;

/**
 * @author wakita 線分ボタンに関わる機能を MVC モデルに準じて一括して実装しています．
 */
class RectangleTool extends RectangularTool {
    RectangleTool(Container container) {
        Control control = new Control();
        View view = new View(container);
        view.button().addActionListener(control);
    }

    class Control extends RectangularTool.Control {
        Rectangular.Factory rectangularFactory(int x, int y) {
            return new Rectangle.Factory(x, y);
        }
    }

    class View extends RectangularTool.View {
        protected View(Container container) {
            super("長方形", container);
        }
    }
}
