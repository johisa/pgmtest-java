package com.pierceecom.pgmtest;

import java.util.NoSuchElementException;

/**
 * A data structure for LIFO (Las In First Out)
 *
 * @author pejo
 * @param <T>
 */
public interface Stack<T> extends Iterable<T> {

    /**
     * Adds en element to the Stack
     *
     * @param item
     */
    void push(T item);

    /**
     * removes an item from the Stack
     *
     * @return the item
     * @throws NoSuchElementException if there are no items in the stack
     */
    T pop();

    /**
     * Check if the stack is empty
     *
     * @return true if stack is empty
     */
    boolean isEmpty();

    /**
     * The size of the stack
     *
     * @return size, the number of items in the stack
     */
    int size();
}
