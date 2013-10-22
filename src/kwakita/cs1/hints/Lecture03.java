package kwakita.cs1.hints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Lecture03 {

  @SuppressWarnings("unused")
  void run() {
    double e = Math.E, pi = Math.PI;

    List<String> l1 = Collections.EMPTY_LIST;

    // Generics を用いて，要素の型を制約したリストの例．
    List<Integer> ints = new ArrayList<Integer>();
    ints.add(0);
    // ints.add("Hello") は型エラーとなる．

    // Generics を用いない場合，Javaのコンパイラは要素の型情報が得られない．
    // このため，危険性を含むコードへの検査が甘くなる．
    List ints_old_fashioned = new ArrayList();
    ints_old_fashioned.add("hello");
    ints_old_fashioned.add(0);

    Map<String, List<String>> fb_friends =
        new TreeMap<String, List<String>>();
  }
}