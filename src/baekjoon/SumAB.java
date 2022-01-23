package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class SumAB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A+B);


        BigInteger bigA = sc.nextBigInteger();
        BigInteger bigB = sc.nextBigInteger();
        System.out.println(bigA.add(bigB));


    }

}
