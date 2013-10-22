package kwakita.cs1.hints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wakita
 * 河内さんのカレンダーの課題をやってみました．
 * Java のプログラムから /usr/bin/cal を呼び出す不真面目なバージョンです．
 * つまらないバグがなければ課題の仕様は満たしているはず．
 * 
 * もちろん，これを提出した場合の反応への責任は持ちません．
 * Java から外部コマンドを呼び出す方法，外部コマンドの出力やエラー出力を取得する方法など参考になる点が多いと思います．
 * 
 * 以下の要領で起動してみて下さい．
 *   java kwakita.cs1.hints.CalendarCheat
 *   java kwaktia.cs1.hints.CalendarCheat 2013
 *   java kwaktia.cs1.hints.CalendarCheat 2013 9
 *   java kwaktia.cs1.hints.CalendarCheat -help
 */
public class CalendarCheat {

  /**
   * 与えられた入力ストリームを一行ずつ読み，出力する．
   * @param is
   * @throws IOException
   */
  void printInputStream(InputStream is) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(is));
    try {
      while (true) {
        String l = r.readLine();
        if (l == null) return;
        System.out.println(l);
      }
    } finally {
      is.close();
    }
  }
  
  void run(String[] args) throws IOException, InterruptedException {

    // Javaのコマンド行引数をもとに外部コマンド（ここでは /usr/bin/cal）のコマンド行を作成．
    List<String> cmdline = new ArrayList<String>();
    cmdline.add("/usr/bin/cal");
    for (int i = 0; i < args.length; i++) cmdline.add(args[i]);

    // プロセスのビルダーを作成．
    // 簡単にプロセスを始動するのならば Runtime.exec で十分ですが，エラー出力を取得するためにはより高機能なプロセスビルダーが必要になります．
    ProcessBuilder pb = new ProcessBuilder(cmdline);

    // エラー出力を標準出力と混合させて一緒に受け取るための設定
    pb.redirectErrorStream(true);
    // cal を英語モードで起動するために環境変数を設定．デフォルトの日本語モードだと漢字モードの設定が面倒だったので逃げた．
    pb.environment().put("LANG", "C");

    // プロセスを起動して，終了を待つ．
    // プロセスにとっては出力だけれども，その出力を受け取るこのプログラムにとっては入力なので getInputStream を読んでいる．やや混乱しますね．
    // p.waitFor はコマンドの実行結果を表す終了コード．Mac OS X を含めて UNIX では，exitcode = 0 が正常終了．ほかは異常終了です．
    // exitcode の番号でエラーの種類を知らせます．
    Process p = pb.start();
    int exitcode = p.waitFor();
    
    // プロセスの出力の内容を得て終了．
    printInputStream(p.getInputStream());
    System.exit(exitcode);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    new CalendarCheat().run(args);
  }
}
