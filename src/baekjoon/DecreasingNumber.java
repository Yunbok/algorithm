package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DecreasingNumber {

    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if ( N <= 10) {
            System.out.println(N);
        } else {
            for (int i = 0; i < 10; i++) {
                calc((long)i , 1);
            }
            Collections.sort(list);

            if (list.size() <= N) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(N));
            }
        }
    }


    public static void calc(long num , int digit) {

        //자리수가 10을 넘으면 리턴
        //9876543210
        if (digit > 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {

                calc((num * 10) + (long)i,digit + 1 );
            }
        }

    }
}
