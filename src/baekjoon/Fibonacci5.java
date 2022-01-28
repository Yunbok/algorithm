package baekjoon;

import java.util.Scanner;

public class Fibonacci5 {

    static int[] fibo = new int[21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        fibo[0] = 0;
        fibo[1] = 1;

        System.out.println(fibonacci(N));
    }


    public static int fibonacci(int index ) {
        if (index == 0){
            return fibo[0];
        } else if( index == 1) {
            return fibo[1];
        }
        fibo[index] = fibonacci(index -1) + fibonacci(index -2);

        return fibo[index];
    }
}
