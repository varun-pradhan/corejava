package org.example;

/**
 * This class provides a hands-on example to understand Tail Recursion.
 * It contrasts a standard "head-recursive" factorial implementation
 * with a "tail-recursive" one, and explains the underlying concepts.
 */
public class TailRecursionExample {

    // --- 1. Standard "Head" Recursion ---
    // This is the typical recursive factorial implementation.
    // It is NOT tail-recursive.
    public static int headRecursiveFactorial(int n) {
        // Base Case
        if (n <= 1) {
            return 1;
        }
        // Recursive Step: The multiplication happens *after* the recursive call returns.
        // The function must wait for fact(n-1) to finish, then multiply by n.
        // This requires holding frames on the call stack.
        return n * headRecursiveFactorial(n - 1);
    }


    // --- 2. Tail Recursion ---
    // This is the public-facing function that users will call.
    public static int tailRecursiveFactorial(int n) {
        // We start the recursive process with an initial accumulator value of 1.
        return factorialHelper(n, 1);
    }

    /**
     * This is the helper function that performs the actual tail recursion.
     * @param n The current number.
     * @param accumulator The accumulated product from previous steps.
     */
    private static int factorialHelper(int n, int accumulator) {
        // Base Case: If n is 1 or 0, the calculation is done.
        // The final answer is the value stored in the accumulator.
        if (n <= 1) {
            return accumulator;
        }

        // Recursive Step: The recursive call is the ABSOLUTE LAST operation.
        // The multiplication (n * accumulator) is calculated *before* the next call.
        // The function doesn't need to do anything after the helper returns.
        return factorialHelper(n - 1, n * accumulator);
    }

    public static void main(String[] args) {
        int number = 5;

        System.out.println("--- Understanding Recursion ---");
        System.out.println("Calculating factorial for: " + number);
        System.out.println();

        // --- Head Recursion Call ---
        int headResult = headRecursiveFactorial(number);
        System.out.println("Head-Recursive Factorial Result: " + headResult);
        System.out.println(" -> In head recursion, the call stack grows because each function call must wait for the one below it to finish.");
        System.out.println(" -> e.g., 5 * (4 * (3 * (2 * 1)))");
        System.out.println();

        // --- Tail Recursion Call ---
        int tailResult = tailRecursiveFactorial(number);
        System.out.println("Tail-Recursive Factorial Result: " + tailResult);
        System.out.println(" -> In tail recursion, the intermediate result is passed down (as the accumulator).");
        System.out.println(" -> The recursive call is the final act, passing the baton without waiting.");
        System.out.println();

        System.out.println("--- IMPORTANT JAVA NOTE ---");
        System.out.println("While this demonstrates the tail-recursive *style*, the standard Java compiler does NOT perform Tail Call Optimization (TCO).");
        System.out.println("This means both versions will build the call stack in the same way in Java, and both can cause a StackOverflowError for large inputs.");
    }
}
