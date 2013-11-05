package kwakita.cs1.s05avoid_creation;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author wakita
 * このアプリケーションで日本標準時は予め定数(終始変化しないこと)がわかっている．
 * 定数とわかっているものを使用のたびに作り直すのは効率が悪かった(Person1の例)
 * ここでは，日本標準時をJavaの定数として一回だけ作成することで効率的な実装となっている．
 */
public class Person2 implements Person {
  private final Date            birthDate;
  private static final Calendar 日本標準時 = Calendar.getInstance(TimeZone
      .getTimeZone("JST"));

  public Person2(int year, int month, int date) {
    日本標準時.set(year, month, date);
    birthDate = 日本標準時.getTime();
  }

  private static final Date 昭和最初の日, 昭和最後の日;
  static {
    日本標準時.set(1926, Calendar.DECEMBER, 24); // 1926/12/25 0:0
    昭和最初の日 = 日本標準時.getTime();

    日本標準時.set(1989, Calendar.JANUARY, 7); // 1989/1/8 0:0
    昭和最後の日 = 日本標準時.getTime();
  }

  public boolean 昭和生れですか() {
    return (birthDate.compareTo(昭和最初の日) >= 0 && birthDate
        .compareTo(昭和最後の日) < 0);
  }
}
