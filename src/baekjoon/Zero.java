package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Zero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                stack.pop();
                continue;
            }
            stack.add(num);
        }
        int sum = 0;

        for (int money : stack) {
            sum += money;
        }
        System.out.println(sum);
    }
}
