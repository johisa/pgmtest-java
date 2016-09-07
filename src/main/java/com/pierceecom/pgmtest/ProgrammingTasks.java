package com.pierceecom.pgmtest;

/**
 * Methods to implement for programming test. Implement these in ProgramminTasksImpl
 * @author pejo
 * @author johisa
 */
public interface ProgrammingTasks {


    /**
     * Vänder på en sträng, ex: "sträng" => "gnärts"
     * @param s
     * @return the reversed String, a null input returns null.
     */
     String reverse(String s);

    /**
     * Räknar ut fibonacci-talet för n. 0,1,1,2,3,5,8,13....
     * @param n, max value of 46 due to integer range limit.
     * @return the corresponding fibonnaci number for input n. Negative input returns 0.
     * @throws ArithmeticException for n > 46 due to integer limitations
     */
    int fib(int n);

    /**
     * Summerar värden som är "tal" i en sträng och ignorerar bokstäver
     * @param numbers, minus signed or unsigned (positive). All other
     *                 characters are separators.
     * @return the sum of the numbers in the string
     * @throws ArithmeticException for sums outside the integer range
     * @throws NumberFormatException for numbers outside the integer range
     */
    int sumString(String numbers);

    /**
     * Vänder ordningen i en array
     * @param arr
     * @return the array in reversed order, a null input returns null.
     */
    int[] reverseArray(int[] arr);

    /**
     * Hittar högsta talet i en array
     * @param nums
     * @return
     */
    default int findHigh(int[] nums) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Omvandlar RGB tal till en hexadecimal sträng med inledande #
     * tal under F (16) inleds med "0"
     * @param r
     * @param g
     * @param b
     * @return
     */
    default String rgbToHex(int r, int g, int b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
