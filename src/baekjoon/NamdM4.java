package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class NamdM4 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        eachNumber(N, M);

        System.out.println(sb.toString());
    }

    private static void eachNumber(int n, int depth) {

        for (int i = 1; i <= n; i++) {

            if (depth != M && stack.peek() > i) {
                continue;
            }
            if (depth != 1 ){
                stack.push(i);
                eachNumber(n, depth - 1);
                stack.pop();
            } else {
                stack.forEach(node -> {
                    sb.append(node).append(" ");
                });
                sb.append(i);
                sb.append("\n");
            }
        }
    }
}
