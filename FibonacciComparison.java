import java.util.Scanner;

public class FibonacciComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        // Calculate recursive time
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        // Calculate iterative time
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Print results
        System.out.println("Fibonacci Number (N): " + n);
        System.out.println("Recursive Result: " + recursiveResult + " | Time: " + recursiveTime / 1_000_000.0 + " ms");
        System.out.println("Iterative Result: " + iterativeResult + " | Time: " + iterativeTime / 1_000_000.0 + " ms");
    }

    // Recursive approach
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

/*
Example Run:

I/P ->
Enter number: 10

O/P ->
Fibonacci Number (N): 10
Recursive Result: 55 | Time: 0.014917 ms
Iterative Result: 55 | Time: 0.001125 ms
 */

