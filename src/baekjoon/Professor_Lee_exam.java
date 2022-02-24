package baekjoon;

import java.util.Scanner;

public class Professor_Lee_exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i = 1; i <= 10; i++) {
            int temp = ((i-1) % 5) + 1;
            sb.append(temp);
            if(i != 10) {
                sb.append(" ");
            }
        }
        answer = sb.toString();

        for (int i = 0; i < N; i++) {
            String text = sc.nextLine();
            if (text.equals(answer)) {
                System.out.println(i+1);
            }
        }
    }
}
