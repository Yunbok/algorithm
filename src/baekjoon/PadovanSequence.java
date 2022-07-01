package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        int N = Integer.parseInt(bf.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;

        for (int i = 7; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dp[Integer.parseInt(bf.readLine())]);
        }
        System.out.println();
        System.out.println();
        for (int i = 1; i <= 100; i++) {
            System.out.println(dp[i]);
        }
    }
}
