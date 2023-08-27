package telran.jcf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import telran.interviews.MyStack;

class MyStackTests {
	MyStack<Integer> stack = new MyStack<>();

	@Test
	void pushTest() {
		stack.clear();
		
		stack.push(1);
		assertEquals(1, stack.peek());		
		stack.push(2);
		assertEquals(2, stack.peek());
		stack.push(3);
		assertEquals(3, stack.peek());
	}
	
	@Test
	void popTest() {
		stack.clear();
		
		stack.push(1);		
		stack.push(2);
		stack.push(3);
		
		var expected = stack.peek();
		assertEquals(expected, stack.pop());
		expected = stack.peek();
		assertEquals(expected, stack.pop());
		expected = stack.peek();
		assertEquals(expected, stack.pop());
		
		assertThrowsExactly(NoSuchElementException.class, () -> stack.pop());
	}
	
	@Test
	void isEmptyTest() {
		stack.clear();
		
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void getMaxTest() {
		stack.clear();
		
		assertThrowsExactly(NoSuchElementException.class, () -> stack.getMax());
		stack.push(10);
		assertEquals(10, stack.getMax());
		stack.push(5);
		assertEquals(10, stack.getMax());
		stack.push(50);
		assertEquals(50, stack.getMax());
		
		
		stack.pop();
		assertEquals(10, stack.getMax());
		stack.pop();
		assertEquals(10, stack.getMax());
		stack.pop();
		assertThrowsExactly(NoSuchElementException.class, () -> stack.getMax());
	}
	
	@Test
	void customCompTest() {
		stack = new MyStack<Integer>((e1, e2) -> e2 - e1);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(1, stack.getMax());	
	}

}
