package baekjoon;

import java.util.Scanner;

public class MovieDirector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int index = 1;
        int value = 666;

        while ( N > index ){
            value++;
            if (String.valueOf(value).contains("666")) {
                index++;
            }
        }

        System.out.println(value);

    }
}
