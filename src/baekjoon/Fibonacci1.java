package baekjoon;

import java.util.Scanner;

public class Fibonacci1 {
    public static int dpCount;
    public static int recursionCount;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        recursion(n);
        dp(n);

        System.out.println(recursionCount + " " + dpCount);

    }

    public static int recursion(int n) {

        if (n == 1 || n == 2) {
            recursionCount++;
            return 1;
        } else {
            return (recursion(n-1) + recursion(n - 2));
        }

    }

    public static int dp(int n) {
        int[] f = new int[n + 1];

        f[1] = f[2] = 1;
        for (int i = 3; i < n + 1; i++ ) {
            f[i] = f[i - 1] + f[i - 2];
            dpCount++;
        }
        return f[n];
    }
}
