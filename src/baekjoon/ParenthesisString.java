package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisString {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            char[] chars = bf.readLine().toCharArray();

            for (char ps : chars) {

                if (ps == ')') {
                    if (stack.isEmpty()) {
                        stack.push(ps);
                        break;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ps);
                    }
                    continue;
                }
                stack.push(ps);
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
