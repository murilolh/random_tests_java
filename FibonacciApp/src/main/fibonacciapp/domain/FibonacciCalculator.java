package fibonacciapp.domain;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCalculator {

    /**
     * Classic recursive method.
     *
     * @param n input
     * @return n-th fibonacci number
     */
    public Long fibonacciRecursive(Integer n) {
        if (n <= 1) {
            printIteration(n, n.longValue());
            return n.longValue();
        }
        long result = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        printIteration(n, result);
        return result;
    }

    /**
     * Recursive method with memoization.
     *
     * @param n input
     * @return n-th fibonacci number
     */
    public Long fibonacciRecursiveMemo(Integer n) {
        List<Long> memo = new ArrayList<>();
        memo.add(0L);
        memo.add(1L);
        printIteration(0, 0L);
        printIteration(1, 1L);
        return fibonacciMemo(n, memo);
    }

    /**
     * Recursive method with memoization.
     *
     * @param n    input
     * @param memo List to store previous computations
     * @return n-th fibonacci number
     */
    private Long fibonacciMemo(Integer n, List<Long> memo) {
        if (n <= 1) {
            printIteration(n, memo.get(n));
            return n.longValue();
        } else if (memo.size() > n && memo.get(n) != null) {
            printIteration(n, memo.get(n));
            return memo.get(n);
        }
        Long result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        memo.add(result);

        printIteration(n, result);
        return result;
    }

    /**
     * Non-recursive solution.
     *
     * @param n input
     * @return n-th fibonacci number
     */
    public Long fibonacciNonRecursive(Integer n) {
        if (n <= 1) {
            return n.longValue();
        }

        printIteration(0, 0L);
        printIteration(1, 1L);

        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = fib;
            printIteration(i , fib);
        }

        return fib;
    }

    private void printIteration(int n, long value) {
        System.out.println(n + " : " + value);
    }
}
