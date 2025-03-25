import java.util.Scanner;

public class StringConcatenationComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take user input for number of concatenations
        System.out.print("Enter number of concatenations: ");
        int n = scanner.nextInt();

        // Calculate performance
        long stringTime = testStringConcatenation(n);
        long stringBuilderTime = testStringBuilder(n);
        long stringBufferTime = testStringBuffer(n);

        // Print results
        System.out.println("Number of concatenations: " + n);
        System.out.println("String (O(N^2)) Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder (O(N)) Time: " + stringBuilderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer (O(N)) Time: " + stringBufferTime / 1_000_000.0 + " ms");
    }

    // String Concatenation using Immutable String
    public static long testStringConcatenation(int n) {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            // Creates a new object every time (inefficient)
            str += "a";
        }
        return System.nanoTime() - startTime;
    }

    // String Concatenation using StringBuilder
    public static long testStringBuilder(int n) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }

    // String Concatenation using StringBuffer
    public static long testStringBuffer(int n) {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }
}

/*
Example Run:

I/P ->
Enter number of concatenations: 10000

O/P ->
Number of concatenations: 10000
String (O(N^2)) Time: 12.548 ms
StringBuilder (O(N)) Time: 0.134 ms
StringBuffer (O(N)) Time: 0.145 ms
 */
