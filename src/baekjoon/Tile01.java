package baekjoon;

import java.util.Scanner;

public class Tile01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] tileArr = new int[N+1];

        tileArr[0] = 0;
        tileArr[1] = 1;


        if (N == 1) {
            System.out.println(tileArr[N]);
        } else {
            tileArr[2] = 2;
            for (int i = 3; i <= N; i++) {
                tileArr[i] = (tileArr[i - 1] + tileArr[i - 2])  % 15746;
            }
            System.out.println(tileArr[N]);
        }
    }
}
