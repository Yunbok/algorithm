package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int result = 0;
        int[] resultArr = new int[person];
        int[] pTime = new int[person];

        for( int i = 0; i < person ; i++ ){
            pTime[i] = sc.nextInt();
        }
        Arrays.sort(pTime);

        resultArr[0] = pTime[0];
        result = resultArr[0];

        for( int i = 1; i < person ; i++ ){
            resultArr[i] = resultArr[i-1] + pTime[i];
            result += resultArr[i];
        }
        System.out.println(result);
    }

}
