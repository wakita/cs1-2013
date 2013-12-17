package kwakita.cs1.app.techdraw;

import java.awt.Graphics2D;
import java.awt.Shape;

/**
 * <p>TechDraw が扱う図形一般を表現する抽象クラスです．このクラスを充実させることで TechDraw の機能拡張ができます．
 * @author Ken Wakita
 */
abstract class TDShape {
    /**
     * 図形の形状を表したもの．
     */
    protected Shape shape;
    
    /**
     * 図形の外形線を描画するためのメソッド
     * @param g
     */
    public void draw(Graphics2D g) {
        g.draw(shape);
    }
    
    /**
     * 図形の内側を塗り潰すためのメソッド
     * @param g
     */
    public void fill(Graphics2D g) {
        draw(g);
        g.fill(shape);
    }
}
