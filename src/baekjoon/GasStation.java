package baekjoon;

import java.util.Scanner;

public class GasStation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int city = sc.nextInt();
        long[] distance = new long[city-1];
        long[] gasPrice = new long[city];
        long result = 0;
        long temp = 0;

        for ( int i = 0; i < distance.length; i++){
            distance[i] = sc.nextInt();
        }
        for ( int i = 0; i < gasPrice.length; i++){
            gasPrice[i] = sc.nextInt();
        }

        temp = gasPrice[0];
        result += distance[0] * temp;
        for ( int i = 1; i < distance.length; i++){
            if (temp <= gasPrice[i]) {
                result += distance[i] * temp;
                continue;
            }
            temp = gasPrice[i];
            result += distance[i] * temp;
        }
        System.out.println(result);
    }
}
