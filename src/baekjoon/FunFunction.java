package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunFunction {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String readLine = bf.readLine();
            if (readLine.equals("-1 -1 -1")) {
                break;
            }

            String[] splitStr = readLine.split(" ");

            System.out.print("w(" + splitStr[0] + ", " + splitStr[1] + ", " + splitStr[2]  + ") = ");
            System.out.println(w(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[1]), Integer.parseInt(splitStr[2])));
        }

    }
    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        int dpNum = dp[a][b][c];
        if (dpNum > 0) {
            return dpNum;
        }

        if (a < b && b < c) {
           dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
           return dp[a][b][c];
        }

        dp[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}
