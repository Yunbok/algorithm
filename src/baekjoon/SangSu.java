package baekjoon;

import java.util.Scanner;

public class SangSu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String num1 = new StringBuilder(sc.next()).reverse().toString();
        String num2 = new StringBuilder(sc.next()).reverse().toString();

        System.out.println(stringNumComparison(num1, num2));
    }

    private static String stringNumComparison(String num1, String num2) {
        if ((Integer.parseInt(num1) < Integer.parseInt(num2))) {
            return num2;
        }
        return num1;
    }
}
