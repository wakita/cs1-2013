package kwakita.cs1.app.techdraw;

import java.awt.Container;
import java.awt.event.ActionEvent;

/**
 * @author wakita
 * このクラスは未完成です．TechDraw の GUI に折れ線用のボタンを配置するだけしかしません．
 */
public class PolylineTool {
    static TDCanvas.Model canvasModel = TDCanvas.model;
    static View view;
    static Control control = new Control();

    static void initialize(Container container) {
        new View(container);
    }
    
    /**
     * @author wakita
     * LineTool を参考に折れ線を描画する機能を追加せよ．
     * 作業に入るまえに LineTool に含まれるクラスやそのスーパークラスを熟読すること．
     * 
     * 折れ線の描画は辺に沿って頂点をクリックすることとし，最後の頂点はダブルクリックで示すこととする．
     * ダブルクリックか否かは MouseListener の引数 MouseEvent e を使って「e.getClickCount() >= 2」で判定できる．
     */
    static class Control extends AbstractDrawToolControl {
        public void actionPerformed(ActionEvent e) {
        }
    }
    
    static class View extends AbstractDrawToolButton {
        private View(Container container) {
            super("折れ線", container);
        }
    }
}
