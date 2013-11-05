package kwakita.cs1.s03singleton;

public class DayTest {
  private void run() {
    System.out.println(Day.SUNDAY);
    System.out.println(Day.valueOf("SUNDAY"));
    System.out.println();

    for (Day day : Day.values())
      System.out.printf("%d: %s\n", day.ordinal(), day);
    System.out.println();

    for (int i = 0; i < Day.values().length; i++)
      System.out.printf("%d: %s\n", i, Day.values()[i]);
    System.out.println();
  }

  public static void main(String... _) {
    new DayTest().run();
  }
}
