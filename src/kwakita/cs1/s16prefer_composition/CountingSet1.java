package kwakita.cs1.s16prefer_composition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountingSet1<E> implements CountingSet<E> {
	private Set<E> s;
	private int addCount = 0;
	public int getCount() { return addCount; }
	public CountingSet1() { s = new HashSet<E>(); }
	
	public boolean add(E e) {
		addCount++;
		return s.add(e);
	}
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return s.addAll(c);
	}
	public void clear() { s.clear(); }
	public boolean contains(Object o) { return s.contains(o); }
	public boolean containsAll(Collection<?> c) { return s.containsAll(c); }
	public boolean isEmpty() { return s.isEmpty(); }
	public Iterator<E> iterator() { return s.iterator(); }
	public boolean remove(Object o) { return s.remove(o); }
	public boolean removeAll(Collection<?> c) { return s.removeAll(c); }
	public boolean retainAll(Collection<?> c) { return s.retainAll(c); }
	public int size() { return s.size(); }
	public Object[] toArray() { return s.toArray(); }
	public <T> T[] toArray(T[] a) { return s.toArray(a); }
}
