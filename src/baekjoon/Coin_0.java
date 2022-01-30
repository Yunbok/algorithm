package baekjoon;

import java.util.Scanner;

public class Coin_0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] coinArr = new int[N][2];

        int tempK = K;
        int result = 0;

        for(int i = 0; i < N ; i++) {
            coinArr[i][0] = sc.nextInt();
        }

        for (int j = N; j > 0; j--) {
            coinArr[j-1][1] = tempK / coinArr[j-1][0];
            tempK = tempK - ( coinArr[j-1][0] * coinArr[j-1][1] );
            result += coinArr[j-1][1];
        }

        System.out.println(result);
    }
}
