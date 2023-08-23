package telran.interviews;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyStack<T> {
	private Frame last;
	private Frame lastMax;
	private Comparator<T> comp;
	
	public MyStack(Comparator<T> comp) {
		this.comp = comp;
	}
	
	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.naturalOrder());
	}
	
	
	public class Frame {
		public T value;
		public Frame next;
		public Frame prev;
		
		public Frame(T value) {
			this.value = value;
		}
		
		public void addNext(Frame next) {
			next.prev = this;
			this.next = next;
		}
		
		public T remove() {
			if (prev != null) {
				prev.next = null;
				prev = null;
			}
			return value;
		}
	}
	
	
	
	
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return last.value;
	}

	public void push(T element) {
		Frame cur = new Frame(element);
		
		if (isEmpty()) {
			lastMax = new Frame(element);
		} else {
			last.addNext(cur);
			
			if (Objects.compare(element, lastMax.value, comp) > 0) {
				lastMax.addNext(new Frame(element));
				lastMax = lastMax.next;
			}
		}
		last = cur;
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Frame victim = last;
		last = last.prev;
		T removed = victim.remove();

		if (Objects.equals(removed, lastMax.value)) {
			victim = lastMax;
			lastMax = lastMax.prev;
			victim.remove();
		}	
		return removed;
	}
	
	public boolean isEmpty() {
		return last == null;
	}
	
	public T getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return lastMax.value;
	}
	
	public void clear() {
		this.last = null;
		this.lastMax = null;
	}
	
	
	
	


}
