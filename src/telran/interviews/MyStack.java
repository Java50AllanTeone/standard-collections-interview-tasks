package telran.interviews;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyStack<T> {
	private Frame<T> last;
	private Frame<T> lastMax;
	private Comparator<T> comp;
	
	public MyStack(Comparator<T> comp) {
		this.comp = comp;
	}
	
	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.naturalOrder());
	}
	
	
	private static class Frame<T> {
		private T value;
		private Frame<T> next;
		private Frame<T> prev;
		
		private Frame(T value) {
			this.value = value;
		}
		
		private void addNext(Frame<T> next) {
			next.prev = this;
			this.next = next;
		}
		
		private T remove() {
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
		Frame<T> cur = new Frame<T>(element);
		
		if (isEmpty()) {
			lastMax = new Frame<T>(element);
		} else {
			last.addNext(cur);
			
			if (Objects.compare(element, lastMax.value, comp) > 0) {
				lastMax.addNext(new Frame<T>(element));
				lastMax = lastMax.next;
			}
		}
		last = cur;
	}

	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		
		Frame<T> victim = last;
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
