package baekjoon;

import java.util.Scanner;

public class StringRepeat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            char[] wordArr = sc.next().toCharArray();

            for (char word : wordArr) {
                for (int j = 0; j < R; j++) {
                    sb.append(word);
                }
            }
            System.out.println(sb);
        }
    }
}
