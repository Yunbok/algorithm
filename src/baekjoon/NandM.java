package baekjoon;

import java.util.Scanner;

public class NandM {
    static int N ;
    static int M ;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        isVisited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            isVisited[i] = true;
            dfs(String.valueOf(i), 1);
            isVisited[i] = false;
        }
    }

    private static void dfs(String num , int digit) {

        if(digit == M) {
            System.out.println(num);
            return;
        }


        for ( int i = 1; i <= N; i++) {
            if(isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            dfs(num + " " + i , digit + 1 );
            isVisited[i] = false;

        }

    }

}
