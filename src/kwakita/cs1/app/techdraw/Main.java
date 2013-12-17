package kwakita.cs1.app.techdraw;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 * @author wakita
 * TechDraw の大まかな構造を定義しています．
 * TechDraw の機能は，各種のボタンやキャンバスで実装されるため，このレベルでは単にビューを構成するのみです．
 */
public class Main {
    static class View {
        private final JFrame frame = new JFrame("TechDraw");
        private final Container root = frame.getContentPane();
        private final JToolBar toolbar = new JToolBar();
        
        View() {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            root.setLayout(new BorderLayout());

            root.add(TDCanvas.view, BorderLayout.CENTER);
            LineTool.initialize(toolbar);
            PolylineTool.initialize(toolbar);
            root.add(toolbar, BorderLayout.NORTH);
            
            frame.pack();
            frame.setVisible(true);
        }
    }

    private void run() {
        new View();
    }
    
    public static void main(String[] _) {
        new Main().run();
    }
}
