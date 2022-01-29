package baekjoon;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DecompositionSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;
        for ( int i = 1; i < N; i++ ) {
            String nToS = Integer.toString(i);
            int decomposition = 0;

            for (int j = nToS.length(); j > 0; j--) {
                decomposition += Integer.parseInt(nToS.substring(j - 1, j));
            }

            if(i+decomposition == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
