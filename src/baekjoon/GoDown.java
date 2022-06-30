package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoDown {
    public static String[][] stairs;
    public static int N;
    public static int maxResult = -1;
    public static int minResult = 999999;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new String[N][3];

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");

            int x1 = Integer.parseInt(st[0]);
            int x2 = Integer.parseInt(st[1]);
            int x3 = Integer.parseInt(st[2]);

            if (i == 0) {
                maxDp[0] = minDp[0] = x1;
                maxDp[1] = minDp[1] = x2;
                maxDp[2] = minDp[2] = x3;
            } else {
                // 최댓값을 구하는 dp 배열
                int beforeMaxDp_0 = maxDp[0], beforeMaxDp_2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x3;
                maxDp[1] = Math.max(Math.max(beforeMaxDp_0, maxDp[1]), beforeMaxDp_2) + x2;
                // 최솟값을 구하는 dp 배열
                int beforeMinDp_0 = minDp[0], beforeMinDp_2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + x1;
                minDp[2] = Math.min(minDp[1], minDp[2]) + x3;
                minDp[1] = Math.min(Math.min(beforeMinDp_0, minDp[1]), beforeMinDp_2) + x2;
            }
        }
        System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
    }
}
