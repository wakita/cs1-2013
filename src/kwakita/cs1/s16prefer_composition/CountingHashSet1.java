package kwakita.cs1.s16prefer_composition;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author wakita
 * 
 * @param <E>
 * 
 *          追加された要素数を勘定し続ける集合を表現したい．この例では単純に add
 *          メソッドを上書きしているけれども，一体，何が起きるのだろうか？不思議な実行結果を観察したあとは，DEBUG = true
 *          にして問題点を調べなさい．
 */
@SuppressWarnings("serial")
class CountingHashSet1<E> extends HashSet<E> implements CountingSet<E> {
  private static final boolean DEBUG = false;

  private int addCount = 0;

  public CountingHashSet1() {}

  public CountingHashSet1(int initCapacity, float loadFactor) {
    super(initCapacity, loadFactor);
  }

  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  public boolean addAll(Collection<? extends E> c) {
    if (DEBUG) {
      System.out.printf("addAll(): size() = %d\n", c.size());
      System.out.printf("addCount = %d\n", addCount);
    }
    addCount += c.size();
    if (DEBUG)
      System.out.printf("addCount = %d\n", addCount);
    boolean r = super.addAll(c);
    if (DEBUG)
      System.out.printf("addCount = %d\n\n", addCount);
    return r;
  }

  public int getCount() { return addCount; }
}
