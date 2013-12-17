package kwakita.cs1.app.techdraw;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author wakita 線分ボタンに関わる機能を MVC モデルに準じて一括して実装しています．
 */
public class LineTool {
    static TDCanvas.Model canvasModel = TDCanvas.model;
    static View view;
    static Control control = new Control();

    static void initialize(Container container) {
        view = new View(container);
        view.button().addActionListener(control);
        view.button().doClick();
    }

    /**
     * @author wakita 線分ボタンがクリックされたときの動作を表現するコントロールクラス．
     */
    static class Control extends AbstractDrawToolControl {
        static Line.Factory factory = null;

        static final MouseListener drawListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                if (factory == null)
                    factory = new Line.Factory(x, y);
                else {
                    factory.add(x, y);
                    canvasModel.add(factory.build());
                    factory = null;
                }
            }
        };

        /**
         * 線分の描画機能は，すぐ上の drawListener
         * で実装されている．ボタンがクリックされたら，キャンバスの描画モードを線分モードに変更するためにキャンバスに drawListener
         * を登録している．詳しくは replaceTool の定義を参照のこと．
         * 
         * @see lecture11.techdraw.AbstractDrawToolControl#switchTool(MouseListener)
         * @see lecture11.techdraw.TDCanvas.Control#switchTool(MouseListener)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {
            switchTool(drawListener);
        }
    }

    static class View extends AbstractDrawToolButton {
        private View(Container container) {
            super("線分", container);
        }
    }
}
