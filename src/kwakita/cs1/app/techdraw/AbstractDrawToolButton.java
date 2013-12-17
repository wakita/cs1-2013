package kwakita.cs1.app.techdraw;

import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * TechDraw アプリケーションでは，さまざまな描画機能を提供します．このクラスはそれらのツールボタンのうち共通化できる機能を抽象クラスとしてまとめたものです．描画ツールを構成するアーキテクチャについては<code>AbstractDrawToolControl</code>に詳しく述べてあります．
 * 
 * @see AbstractDrawToolControl
 * @author Ken Wakita
 */
abstract class AbstractDrawToolButton {
    private static ButtonGroup radioGroup = new ButtonGroup();
    private final AbstractButton button;
    AbstractButton button() {
        return button;
    }
    
    AbstractDrawToolButton(String title, Container container) {
        button = new JRadioButton(title);
        radioGroup.add(button);
        container.add(button);
    }
}
