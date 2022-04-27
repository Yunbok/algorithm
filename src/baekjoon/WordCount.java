package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim().toLowerCase();
        if (text.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Arrays.stream(text.split(" ")).count());
        }

    }
}
