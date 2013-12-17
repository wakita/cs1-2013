package kwakita.cs1.app.techdraw;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>Line</code>クラスは線分の描画を表現したクラスです．線分の描画におけるインタラクションは<code>LineTool</code>クラスに実装されており，このクラスに記述されているのは，描画に関わる部分のみです．
 * 
 * <p>線分のインタラクションでは，ユーザは最初のクリックで始点を，次のクリックで終点を指定します．線分の描画には始点と終点がともに必要ですから，始点が指定された時点ですぐに線分を作成することができません．終点の場所が確定するまで，始点の情報を記憶しておかなくてはなりません．講義のなかで，static factory methodについて勉強しましたが，ここでの例はSFMの利用の典型例となります．
 * 
 * <p>ファクトリは，始点と終点を<code>Point</code>のリストとして記憶します．始点のクリックでファクトリが作成されますので，ファクトリのコンストラクタには始点の座標を与えます．次のクリックで終点がきまりますが，その情報はファクトリのaddメソッドで指定されます．
 * 
 * <p>始点と終点が定まったら，線分を描画できます．<code>Factory</code>クラスの<code>build</code>メソッドが<code>Line</code>クラスのインスタンスを作成します．SFM でも述べましたが，ここでは無闇に<code>Line</code>クラスのコンストラクタがよそのクラスから呼ばれないように，このコンストラクタは<code>private</code>宣言されています．
 * 
 * <p>ここで定義している<code>Line</code>クラスは実際のところ，描画はしていません．単に形状の情報を<code>Line2D.Double</code>クラスのインスタンスとして記憶しているにすぎません．実際の描画は<code>TDCanvas</code>が行っています．
 * 
 * @author Ken Wakita
 * @see LineTool
 * @see TDCanvas
 */
class Line extends TDShape {
    /**
     * @param points 点列を表す<code>List</code>．始点と終点の二つを要素としているはず．
     */
    private Line(List<Point> points) {
        assert points.size() == 2;
        shape = new Line2D.Double(points.get(0), points.get(1));
    }

    static final class Factory {
        private List<Point> points = new LinkedList<Point>();

        Factory(int x, int y) {
            points.add(new Point(x, y));
        }

        void add(int x, int y) {
            points.add(new Point(x, y));
        }

        Line build() {
            return new Line(points);
        }
    }
}
