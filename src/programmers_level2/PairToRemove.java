package programmers_level2;

import java.util.Stack;

public class PairToRemove {

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));

        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();

        while (sb.length() > 0) {
            System.out.println("sb = " + sb.charAt(0));
            if (stack.isEmpty()) {
                stack.push(sb.charAt(0));
                sb.deleteCharAt(0);
                continue;
            }

            if (stack.peek() == sb.charAt(0)) {
                sb.deleteCharAt(0);
                stack.pop();
            } else {
                stack.push(sb.charAt(0));
                sb.deleteCharAt(0);
            }

        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }


    }
}
