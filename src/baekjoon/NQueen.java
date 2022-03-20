package baekjoon;

import java.util.Scanner;

public class NQueen {
    static int[] board;
    static boolean[][] isVisit;
    static int count = 0;
    static int n;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[15];

        dfs(0);
        System.out.println(count);
    }
    static boolean promising(int index) {

        for (int i = 0; i < index; i++) {

            //같은줄에 있는지 검사  2 == 2 는 3번째줄에 겹칠경우 / 대각선 의 절대값이 같은경우는 대각선에 값이 존재
            if( board[index] == board[i] || index - i == Math.abs(board[index] - board[i])) {
                return false;
            }

        }
        return true;

    }


    public static void dfs(int index) {
        if (index == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[index] = i;

            if(promising(index)) {
                dfs(index + 1);
            }
        }

    }


}
