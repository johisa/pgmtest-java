package com.pierceecom.pgmtest;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programming tasks implementation
 *
 * @author johisa
 */
public class ProgrammingTasksImpl implements ProgrammingTasks {

    @Override
    public String reverse(String s) {
        return StringUtils.reverse(s);
    }

    /**
     * Recursive fib implementation.
     *
     * In many cases a recursive solution might be considered bad given the risk
     * of StackOverflowError. But in this case we are limited by the integer range
     * which the calculations to the 46th fib number before we break out of recursion
     * due to an ArithmeticException.
     *
     */
    public int fib(int n) {
        int initAcc1 = 1, initAcc2 = 0;
        return fibAccumulator(initAcc1, initAcc2, n);
    }

    private int fibAccumulator(int accumulator1, int accumulator2, int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return Math.addExact(accumulator1, accumulator2);
        } else {
            return fibAccumulator(accumulator2,  Math.addExact(accumulator1, accumulator2), n - 1);
        }
    }

    @Override
    public int sumString(String numbers) {
        if(StringUtils.isEmpty(numbers))
            return 0;

        return sum(pattern().matcher(numbers));
    }

    /**
     * @return a number pattern that include negative numbers
     */
    private Pattern pattern() {
        return Pattern.compile("-?\\d+");
    }

    private int sum(Matcher numbers) {
        int sum = 0;
        while (numbers.find()) {
           sum = Math.addExact(sum, Integer.parseInt(numbers.group()));
        }
        return sum;
    }

    @Override
    public int[] reverseArray(int[] arr) {
        ArrayUtils.reverse(arr);
        return arr;
    }
}
