package telran.interviews;

import java.util.*;

public class MyArray<T> {
	Map<Integer, T> map;
	int size;
	T defaultValue = null;
	
	
	public MyArray(int size) {
		this.size = size;
		map = new HashMap<>(size + 1, 1);
	}

	
	public void setAll(T value) {
		defaultValue = value;
		map = new HashMap<>(size + 1, 1);	
	}


	
	public T get(int index) {
		var res = map.get(index);		
		return Objects.isNull(res) ? defaultValue : res;
	}


	public void set(int index, T value) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		map.put(index, value);
	}
}