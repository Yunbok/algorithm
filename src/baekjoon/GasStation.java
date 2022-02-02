package baekjoon;

import java.util.Scanner;

public class GasStation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int city = sc.nextInt();
        int[] distance = new int[city-1];
        int[] gasPrice = new int[city];
        int passCity = 0;
        int result = 0;
        int temp = 0;


        for ( int i = 0; i < distance.length; i++){
            distance[i] = sc.nextInt();
        }
        for ( int i = 0; i < gasPrice.length; i++){
            gasPrice[i] = sc.nextInt();
        }

        temp = gasPrice[0];
        for ( int i = 1; i < gasPrice.length; i++){
            if (temp <= gasPrice[i]) {
                passCity++;
                continue;
            }
            for (int j = passCity; j >= 0; j--) {
                result += distance[i - j -1] * temp;
            }
            passCity = 0;
            temp = gasPrice[i];
        }
        if ( passCity != 0) {
            for (int j = passCity; j > 0; j--) {
                result += distance[distance.length - j] * temp;
            }
        }
        System.out.println(result);
    }
}
