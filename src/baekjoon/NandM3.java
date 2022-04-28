package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class NandM3 {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        eachNumber(N, M);

        System.out.println(sb.toString());
    }

    private static void eachNumber(int n, int depth) {

        for (int i = 1; i <= n; i++) {

            if (depth != 1) {
                stack.push(i);
                eachNumber(n, depth - 1);
                stack.pop();
            } else {
                stack.forEach(node -> {
                    sb.append(node + " ");
                });
                sb.append(i);
                sb.append("\n");
            }
        }
    }
}
