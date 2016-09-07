package com.pierceecom.pgmtest;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array based stack implementation
 *
 * @param <T>
 * @author pejo
 * @author johisa
 */
public class StackImpl<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] stack;
    private int size;

    /**
     * Stack with default capacity
     */
    public StackImpl(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize the stack with a custom initial capacity
     *
     * Suppressing the unchecked cast since the only way to add
     * items is via the typed push(T) method.
     *
     * @param initialCapacity, a custom initial capacity greater than zero
     * @throws IllegalArgumentException if initialCapacity is not greater than zero
     */
    @SuppressWarnings("Unchecked")
    public StackImpl(int initialCapacity){
        if(initialCapacity <= 0)
            throw new IllegalArgumentException("Stack capacity must be greater than zero");
        stack = (T[])new Object[initialCapacity];
    }

    @Override
    public void push(T item) {
        if(stackIsFull())
            increaseStackCapacity();
        stack[size++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Empty stack");
        T poppedItem = stack[--size];
        stack[size] = null;
        return poppedItem;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean stackIsFull() {
        return stack.length == size;
    }

    /**
     * Suppressing the unchecked cast since the only way to add
     * items is via the typed push(T) method.
     */
    @SuppressWarnings("Unchecked")
    private void increaseStackCapacity() {
        T[] increasedStack =  (T[]) new Object[size * 2];
        System.arraycopy(stack, 0, increasedStack, 0, stack.length);
        stack = increasedStack;
    }

    /**
     * LIFO ordered Iterator.
     *
     * Note that remove() is not supported. Please use pop() to
     * remove items.
     *
     * @return an iterator that iterates through the items in LIFO
     * order
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    /**
     * Iterator for the stack with default implementations of
     * forEachRemaining and remove. The latter because the only
     * modification of the stack should be done via pop() and push(T).
     *
     */
    private class StackIterator implements Iterator<T> {
        int index = size - 1;

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException("No more elements");
            return stack[index--];
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }
    }

}
