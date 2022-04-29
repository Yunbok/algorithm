package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while (true) {
            String readLine = bf.readLine();
            if (readLine.equals(".")) {
                break;
            }
            char[] textArr = readLine.toCharArray();

            for (char text : textArr) {
                if (text == '(' || text == '['  ) {
                    stack.push(text);
                } else if (text == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(text);
                        break;
                    }
                } else if ( text == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(text);
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
                stack.clear();
            }

        }

    }
}
