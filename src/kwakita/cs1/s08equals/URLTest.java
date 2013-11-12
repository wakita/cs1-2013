package kwakita.cs1.s08equals;

import static kwakita.cs1.U.*;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    /**
     * java.net.URL で実装されている equals の整合性が破綻していることを示す実験．
     * 実際には別々の URL を誤って等しいと認識してしまっています．
     */
    private void run() {
        try {
            URL url1 = new URL("http://yahoo.co.jp/");
            URL url2 = new URL("http://f11.top.vip.ogk.yahoo.co.jp/");

            out.printf("\"%s\".equals(\"%s\") = %b\n", url1, url2, url1.equals(url2));
        } catch (MalformedURLException e) { e.printStackTrace(); }
    }

    /*
     * yahoo.co.jp というドメイン名に割り当てられる IP アドレスはときどき変化します．
     * たとえば，2011年11月8日の午前11時ごろには，一時 203.216.243.240 でしたが，
     * やがて 124.83.187.140 に変化しました．
     * 
     * 上の例は 124.83.187.140 になった頃を見計らって作成しました．
     * その時点で f11.top.vip.ogk.yahoo.co.jp の IP アドレスは 124.83.187.140 でした．
     * 
     * これらのことを調査するためには，ターミナルを起動し，host コマンドを使いました．
     * 実験のために使ったコメンドは以下の通りです．
     * 
     * host yahoo.co.jp
     * host 124.83.187.140
     * 
     * 最初のコマンドから yahoo.co.jp に割り当てられた IP アドレスが 124.83.187.140 であることを知りました．
     * 二番目のコマンドによって，その時点で yahoo.co.jp が実は f11.top.vip.ogk.yahoo.co.jp の別名であることを知りました．
     */

    public static void main(String[] _) {
        new URLTest().run();
    }
}
