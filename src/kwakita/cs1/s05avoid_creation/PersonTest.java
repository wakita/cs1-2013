package kwakita.cs1.s05avoid_creation;

import java.util.Random;

/**
 * @author wakita
 * 1024個の誕生日を20正規から無作為に選択した配列から，無作為に抽出し，昭和生れか否かを100万回判定する試行．
 */
public class PersonTest {
  private static final Random r = new Random();
  private static final int    N = 1000000;

  private void test(String message, Person[] persons) {
    System.out.println(message);
    long time = System.currentTimeMillis();
    for (int i = 0; i < N; i++)
      persons[r.nextInt(persons.length)].昭和生れですか();
    System.out.printf("Elapse time = %.2fs\n\n",
        (System.currentTimeMillis() - time) / 1000.0);
  }

  private void run() {
    Person[] persons = new Person[1024];

    for (int i = 0; i < persons.length; i++) {
      int year = 1910 + r.nextInt(100);
      int month = r.nextInt(12);
      int date = r.nextInt(28);
      persons[i] = new Person1(year, month, date);
    }
    test("Person1", persons);

    for (int i = 0; i < persons.length; i++) {
      int year = 1900 + r.nextInt(100);
      int month = r.nextInt(12);
      int date = r.nextInt(28);
      persons[i] = new Person2(year, month, date);
    }
    test("Person2", persons);
  }

  public static void main(String... _) {
    new PersonTest().run();
  }
}
