package io.rtdi.appcontainer.plugins.activation;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple data structure to cache the last n elements
 *
 * @param <E> type of the element to cache
 */
public class RingBuffer<E> {
	private List<E> data;
	private int pos = 0; // index where the next element will be stored
	private int size;
	
	/**
	 * A RingBuffer contains up to size elements, if more elements are added the oldest is overwritten.
	 * 
	 * @param size max size of the ring buffer
	 */
	public RingBuffer(int size) {
		data = new ArrayList<>(size);
		this.size = size;
	}
	
	public void push(E entity) {
		if (pos >= data.size()) {
			data.add(entity);
		} else {
			data.set(pos, entity);
		}
		pos = (pos+1) % size;
	}

	/**
	 * @param relativepos a number between 0 (current element) and -size+1 (n-th previous element) 
	 * @return the cached element
	 */
	public E get(int relativepos) {
		if (data.size() == 0) {
			throw new IllegalArgumentException("No data on the ring buffer");
		} else if (relativepos > 0) {
			throw new IllegalArgumentException(String.format("relativepos %d must be <1, cannot look ahead of the stream", relativepos));
		} else if (relativepos < -size) {
			throw new IllegalArgumentException(String.format("relativepos %d must be >= %d, cannot look past the last %d entities", relativepos, -size, size));
		}
		int p = (pos + relativepos - 1 + size) % size; // make sure the returned value is positive
		if (p < data.size()) {
			return data.get(p);
		} else {
			throw new IllegalArgumentException(String.format("No enough data on the ring buffer, pos=%d, data=%s", pos, data.toString()));
		}
	}

	public int size() {
		return data.size();
	}
}
