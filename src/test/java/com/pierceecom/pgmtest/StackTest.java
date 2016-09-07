package com.pierceecom.pgmtest;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for a Stack of Strings
 *
 * @author pejo
 * @author johisa
 */
public class StackTest {

    private Stack<String> cut;

    @Before
    public void setUp() {
        cut = new StackImpl<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialCapacityNegative() {
        new StackImpl<String>(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialCapacityZero() {
        new StackImpl<String>(0);
    }

    @Test
    public void initialStackShouldBeEmpty() {
        assertTrue(cut.isEmpty());
        assertEquals(0, cut.size());
    }

    @Test
    public void pushAndPopToEmpty() {
        cut.push("A");
        assertFalse(cut.isEmpty());
        assertEquals(1, cut.size());

        cut.push("B");
        assertEquals(2, cut.size());

        assertEquals("B", cut.pop());
        assertEquals(1, cut.size());

        assertEquals("A", cut.pop());
        assertEquals(0, cut.size());

        assertTrue(cut.isEmpty());
    }


    @Test(expected = NoSuchElementException.class)
    public void popEmptyStack() {
        cut.pop();
    }

    @Test
    public void stackGrowth() {
        int customInitCapacity = 5;
        cut = new StackImpl<>(customInitCapacity);

        assertTrue(cut.size() == 0);

        for(int i = 0; i <= customInitCapacity; i++){
            cut.push("a string");
        }

        assertTrue(cut.size() > customInitCapacity);
    }

    @Test
    public void iteratorLifoOrder() {
        cut.push("A");
        cut.push("B");

        String stack = iterateStack();

        assertEquals("BA", stack);
    }

    @Test
    public void iteratorConsistency() {
        cut.push("A");
        cut.push("B");
        assertEquals(iterateStack(), iterateStack());
    }

    private String iterateStack() {
        String stack = "";
        for (String item : cut) {
            stack += item;
        }
        return stack;
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNoMoreElements() {
        cut.iterator().next();
    }
}
