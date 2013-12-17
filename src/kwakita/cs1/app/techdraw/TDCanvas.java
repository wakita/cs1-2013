package kwakita.cs1.app.techdraw;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

/**
 * TechDrawアプリケーションの描画画面を構成しています．TechDrawは図形の描画機能を提供するアプリケーションで，
 * 描画した図形をあとで変更するような編集機能も提供します
 * ．この編集機能を実現するためには，描いた図形の形状を記憶しておき，それを変形することが求められます．画面に描いたビットマップ画像への描画のみで
 * ，この機能を実現することは非常に難しいため
 * ，TechDrawは画面に描く図形の形状の情報を記憶しておき，図形が編集されたときには画面を消去したあとで，すべての図形を描き直します．
 * 
 * <p>
 * <code>AbstractDrawToolControl</code>の説明で，グラフィカルユーザインタフェイス (GUI)
 * を実現するときには，複雑な機能をいくつかに分解することが重要なことを述べました．ここでは，GUI
 * の構成によく利用されるモデル-ビュー-コントロールへの分離の例を示します．モデル-ビュー-コントロール はしばしば MVC
 * とも呼ばれる非常に有名なソフトウェアアーキテクチャです．
 * 
 * <p>
 * モデル (Model) は，GUIアプリケーションが保持する<b>状態</b>を表すクラスです．<code>TCDanvas</code>クラスでは
 * <code>Model</code>クラスで表現し，このアプリケーションを用いて描かれた図形の形状を記憶しています．
 * 
 * <p>
 * ビュー (View) は，GUIアプリケーションの見た目を司ります．<code>TDCanvas</code>クラスでは，図形の描画機能にあたります．
 * 
 * <p>
 * コントロール (Control) は，GUIアプリケーションで利用されるユーザインタラクションにあたります．<code>TDCanvas</code>
 * クラスでは<code>Control</code>クラスで実装され，描画ツールを変更するためのツールボタンの切り替え機能を実現しています．
 * 
 * @author wakita
 * @see AbstractDrawToolControl
 */
public class TDCanvas {
  static Model model = new Model();
  static View view = new View(800, 600);
  static Control control = new Control();

  /**
   * <code>TDCanvas</code>のモデル
   */
  static class Model {

    /**
     * 描画された図形たちの形状を記憶するために用意したリストです．リストの先頭から順番に描画するので，先頭の図形が最も奥に描かれ，後方の図形が手前に描かれると思って下さい．リストのなかの順番は塗り潰された図形が重なったときの描画効果として見えます．
     */
    private static final List<TDShape> shapes = new LinkedList<TDShape>();

    List<TDShape> shapes() {
      return Collections.unmodifiableList(shapes);
    }

    void add(TDShape shape) {
      shapes.add(shape);
      view.update();
    }
  }

  /**
   * <code>TDCanvas</code>のビュー
   */
  @SuppressWarnings("serial")
  static class View extends JComponent {
    /**
     * 描くべき形状のモデル．<code>View</code>コンストラクタのなかで初期化されているようにモデルと共有している．
     */
    List<TDShape> shapes;

    View(int h, int w) {
      view = this;
      this.setPreferredSize(new Dimension(h, w));
      shapes = model.shapes();
    }

    /**
     * <code>shapes</code>の要素として記憶されている各要素を順番に描く
     */
    public void paintComponent(Graphics graphics) {
      Graphics2D g = (Graphics2D) graphics;
      g.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);  // 描画した線のギザギザを抑制するための設定

      for (TDShape shape : shapes) {
        g.setColor(Color.BLUE);
        shape.fill(g);
        g.setColor(Color.BLACK);
        shape.draw(g);
      }
    }

    void update() {
      repaint();
    }
  }

  static class Control {
    private MouseListener currentTool = null;

    void switchTool(MouseListener newTool) {
      // 考察：以下の条件判定が必要とされる理由を考えよ．
      if (this.currentTool != null)
        view.removeMouseListener(newTool);
      view.addMouseListener(newTool);
      // 考察：仮に以下の文を削除すると不可思議な現象が生じる．その様子を想像せよ．
      currentTool = newTool;
    }
  }
}
