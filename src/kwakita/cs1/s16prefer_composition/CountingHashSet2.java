package kwakita.cs1.s16prefer_composition;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author wakita
 * 
 *         CountingHashSet1 の問題をやや強引に修正した例．結果的に情報隠蔽が破綻する．
 * @param <E>
 */
@SuppressWarnings("serial")
class CountingHashSet2<E> extends HashSet<E> implements CountingSet<E> {
  private int addCount = 0;

  public CountingHashSet2() {}

  public CountingHashSet2(int initCapacity, float loadFactor) {
    super(initCapacity, loadFactor);
  }

  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  /**
   * EncapsulationViolation1 の問題から逃げようと試みた例 (一応、問題は回避できるが。。。)
   * 
   * @see java.util.AbstractCollection#addAll(java.util.Collection)
   */
  public boolean addAll(Collection<? extends E> c) {
    // super の addAll は個々の要素について上述の add を呼ぶことを期待して以下を削除してみた。
    // addCount += c.size();
    return super.addAll(c);
  }

  public int getCount() { return addCount; }
}
