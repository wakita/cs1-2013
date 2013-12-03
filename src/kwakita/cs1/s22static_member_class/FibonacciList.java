package kwakita.cs1.s22static_member_class;

import java.util.*;

// 普通のリストのイタレータをカスタマイズして，ヘンテコな振舞いをさせる例
// ArrayList の Iterator を inner class を用いて実装した例
// iterator は、ベクトル (v) をアクセスするため static inner class として定義できない
class FibonacciList implements Iterable<Integer> {
    ArrayList<Integer> v = new ArrayList<Integer>();

    public boolean add(int x) { return v.add(x); }
    public void clear() { v.clear(); }
    public int get(int x) { return v.get(x); }
    public int indexOf(int x) { return v.indexOf(x); }
    public boolean isEmpty() { return v.isEmpty(); }
    public int size() { return v.size(); }
    public Iterator<Integer> iterator() { return new SkipIterator(); }

    private class SkipIterator implements Iterator<Integer> {
        int i = 1, j = 1;  // Fibonacci 系列の発生
        public boolean hasNext() { return i < v.size(); }
        public Integer next() {
            int result = v.get(i);
            int t = i; i = i + j; j = t;
            return result;
        }
        public void remove() {}
    }
    
    public String toString() {
      return Arrays.toString(v.toArray(new Integer[] {}));
    }
}
