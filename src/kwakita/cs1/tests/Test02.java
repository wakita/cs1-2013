package kwakita.cs1.tests;

public class Test02 {
  void hello() {
    System.out.println("Hello World!");
  }
  
  void operators() {
    final int X = 89, Y = 5;
    for (int v : new int[] { X*Y, X/Y, X%Y, X+Y, X-Y, X<<Y, X>>Y, X>>>Y }) System.out.println(v);
    for (boolean v : new boolean[] { X<Y, X>Y, X<=Y, X>=Y, X==Y, X!=Y }) System.out.println(v);
    for (int v : new int[] { X&Y, X|Y, X^Y }) System.out.println(v);
  }
  
  void run() {
    hello();
    operators();
  }
  
  public static void main(String[] _) {
    new Test02().run();
  }
}
