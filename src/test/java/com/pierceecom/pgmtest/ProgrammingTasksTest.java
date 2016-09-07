package com.pierceecom.pgmtest;

import org.junit.Test;
import org.junit.Before;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Tests for programming tasks
 *
 * @author pejo
 * @author johisa
 */
public class ProgrammingTasksTest {

    private static final int MAX_FIB_INPUT_INTEGER = 46;
    private static final int MAX_FIB_VALUE_INTEGER = 1836311903;

    // Class Under Test => cut
    private ProgrammingTasks cut;

    @Before
    public void setUp(){
        cut = new ProgrammingTasksImpl();
    }


    @Test
    public void reverseString() {
        verifyReverseString("reverse", "esrever");
        verifyReverseString(null, null);
        verifyReverseString("", "");
    }

    private void verifyReverseString(String input, String expectedResult){
        assertEquals(expectedResult, cut.reverse(input));
    }

    @Test
    public void fibSequence() {
        verifyFib(0, 0);
        verifyFib(1, 1);
        verifyFib(2, 1);
        verifyFib(3, 2);
        verifyFib(4, 3);
        verifyFib(5, 5);
        verifyFib(6, 8);
        verifyFib(7, 13);
        verifyFib(8, 21);
    }

    @Test
    public void fibNegativeInput() {
        verifyFib(-1, 0);
        verifyFib(-7, 0);
    }

    @Test
    public void fibMaxInput() {
        verifyFib(MAX_FIB_INPUT_INTEGER, MAX_FIB_VALUE_INTEGER);
    }

    private void verifyFib(int input, int expectedResult) {
        assertEquals(expectedResult, cut.fib(input));
    }

    @Test(expected = ArithmeticException.class)
    public void fibIntegerOverflow() {
        cut.fib(MAX_FIB_INPUT_INTEGER + 1);
    }

    @Test
    public void sumString() {
        verifySumString("1 2 3 4  5  6 7 8 9", 45);
        verifySumString("a 10 2  b 23 c  29", 64);
        verifySumString("a102b23c29", 154);
        verifySumString("1229", 1229);
        verifySumString("12.29,9", 50);
        verifySumString("-12 -12----1", -25);
        verifySumString(" abcd14 -12 5", 7);
        verifySumString("", 0);
        verifySumString("noDigits", 0);
        verifySumString(null, 0);
        verifySumString(Integer.toString(Integer.MAX_VALUE), Integer.MAX_VALUE);
        verifySumString(Integer.toString(Integer.MIN_VALUE), Integer.MIN_VALUE);
    }

    private void verifySumString(String input, int expectedResult){
        assertEquals(expectedResult, cut.sumString(input));
    }

    @Test(expected = ArithmeticException.class)
    public void sumStringIntegerOverflowOnSum() {
        cut.sumString(Integer.toString(Integer.MAX_VALUE) + " 1");
    }

    @Test(expected = ArithmeticException.class)
    public void sumStringIntegerUnderflowOnSum() {
        cut.sumString(Integer.toString(Integer.MIN_VALUE) + " -1");
    }

    @Test(expected = NumberFormatException.class)
    public void sumStringIntegerOverflowOnNumber() {
        cut.sumString(integerOverflow());
    }

    @Test(expected = NumberFormatException.class)
    public void sumStringIntegerUnderflowOnNUmber() {
        cut.sumString(integerUnderflow());
    }

    private String integerOverflow() {
        return new BigInteger(
                Integer.toString(Integer.MAX_VALUE))
                .add(BigInteger.ONE)
                .toString();
    }

    private String integerUnderflow() {
        return new BigInteger(
                    Integer.toString(Integer.MIN_VALUE))
                    .subtract(BigInteger.ONE)
                    .toString();
    }

    @Test
    public void testReverseArray() {
        verifyReverseArray(new int[]{1, 23, 3, 14, 15, 24, 23}
                , new int[]{23, 24, 15, 14, 3, 23, 1});
        verifyReverseArray(null, null);
        verifyReverseArray(new int[]{}, new int[]{});
    }

    private void verifyReverseArray(int[] input, int[] expectedResult) {
        assertArrayEquals(expectedResult, cut.reverseArray(input));
    }

    /**
     * Test of findHigh method, of class ProgrammingTasks.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testFindHigh() {
        System.out.println("testFindHigh");
        int[] nums = new int[]{1, 23, 3, 14, 15, 24, 23};
        int expResult = 24;
        int result = cut.findHigh(nums);
        assertEquals(expResult, result);
    }

    /**
     * Test of findHigh method, of class ProgrammingTasks.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testFindHigh2() {
        System.out.println("testFindHigh");
        int[] nums = new int[]{1, 1, 1, 2, 1};
        int expResult = 2;
        int result = cut.findHigh(nums);
        assertEquals(expResult, result);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testRgbToHex() {
        System.out.println("testRgbToHex");

        String expResult = "#000000";
        String result = cut.rgbToHex(0, 0, 0);
        assertEquals(expResult, result);

        expResult = "#1E1E1E";
        result = cut.rgbToHex(30, 30, 30);
        assertEquals(expResult, result);

        expResult = "#141E28";
        result = cut.rgbToHex(20, 30, 40);
        assertEquals(expResult, result);
    }

}
