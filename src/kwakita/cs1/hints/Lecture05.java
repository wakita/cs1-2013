package kwakita.cs1.hints;

import java.util.ArrayList;
import java.util.List;

enum Signal {
  赤, YELLOW, GREEN;
}

enum Sex {
  MALE, FEMALE, KID;
}

public class Lecture05 {
  @SuppressWarnings("unused")
  void doSignal() {
    final int RED = 0, YELLOW = 100, GREEN = 256;
    
    List<Signal> signals = new ArrayList<Signal>();
    signals.add(Signal.GREEN);
    signals.add(Signal.YELLOW);
    signals.add(Signal.赤);
    for (Signal s : signals) System.out.println(s);
  }
  
  public static void main(String[] _) {
    new Lecture05().doSignal();
  }
}
