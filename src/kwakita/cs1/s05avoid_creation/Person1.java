package kwakita.cs1.s05avoid_creation;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 implements Person {
  private final Date birthDate;

  public Person1(int year, int month, int date) {
    Calendar 日本標準時 = Calendar.getInstance(TimeZone.getTimeZone("JST"));
    日本標準時.set(year, month, date);
    birthDate = 日本標準時.getTime();
  }

  public boolean 昭和生れですか() {
    Calendar 日本標準時 = Calendar.getInstance(TimeZone.getTimeZone("JST"));
    日本標準時.set(1926, Calendar.DECEMBER, 24); // 1926/12/25 0:0
    Date 昭和最初の日 = 日本標準時.getTime();
    日本標準時.set(1989, Calendar.JANUARY, 7); // 1989/1/8 0:0
    Date 昭和最後の日 = 日本標準時.getTime();
    return (birthDate.compareTo(昭和最初の日) >= 0 && birthDate
        .compareTo(昭和最後の日) < 0);
  }
}
