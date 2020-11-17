package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * 扩展线程同步功能的代理类
 * 代理模式：在不改变原有功能情况下扩展新功能 
 */
public class ProxyList<E> implements List<E> {
	private List<E> target;//被代理的目标list对象
	public ProxyList() {
		target = new ArrayList<E>();
	}
	public ProxyList(List<E> list) {
		target = list;
	}
	public void add(int index, E element) {
		synchronized (this) {
			target.add(index, element); 
		}
	}
	
	public synchronized int size() {
		return target.size();
	}

	public synchronized boolean isEmpty() {
		return target.isEmpty();
	}

	public synchronized boolean contains(Object o) {
		return target.contains(o); 
	}

	public synchronized Iterator<E> iterator() {
		return target.iterator();
	}

	public synchronized Object[] toArray() {
		return target.toArray();
	}

	public synchronized <T> T[] toArray(T[] a) {
		return target.toArray(a);
	}

	public synchronized boolean add(E e) {
		return target.add(e);
	}
	
	@Override
	public synchronized String toString() {
		return target.toString();
	}

	public synchronized boolean remove(Object o) {
		return target.remove(o);
	}

	public synchronized boolean containsAll(Collection<?> c) {
		return target.containsAll(c);
	}

	public synchronized boolean addAll(Collection<? extends E> c) {
		return target.addAll(c);
	}

	public synchronized boolean addAll(int index, Collection<? extends E> c) {
		return target.addAll(index, c);
	}

	public synchronized boolean removeAll(Collection<?> c) {
		return target.removeAll(c);
	}

	public synchronized boolean retainAll(Collection<?> c) {
		return target.retainAll(c);
	}

	public synchronized void clear() {
		target.clear();
	}

	public synchronized E get(int index) {
		return target.get(index);
	}

	public synchronized E set(int index, E element) {
		return target.set(index, element);
	}

	public synchronized E remove(int index) {
		return target.remove(index); 
	}

	public synchronized int indexOf(Object o) {
		return target.indexOf(o);
	}

	public synchronized int lastIndexOf(Object o) {
		return target.lastIndexOf(o);
	}

	public synchronized ListIterator<E> listIterator() {
		return target.listIterator();
	}

	public synchronized ListIterator<E> listIterator(int index) {
		return target.listIterator(index);
	}

	public synchronized List<E> subList(int fromIndex, int toIndex) {
		return target.subList(fromIndex, toIndex);
	}
	
}
