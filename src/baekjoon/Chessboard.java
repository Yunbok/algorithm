package baekjoon;

import java.util.Scanner;

public class Chessboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int min = 65;
        String[][] board = new String[N][M];

        String[][] black = new String[][]{
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"}
        };

        String[][] white = new String[][]{
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"}
        };

        for ( int i = 0; i < N; i++) {
            String temp = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp.substring(j,j+1);

            }
        }

        for (int i = 0; i < N - 7; i++ ) {
            for (int j = 0; j < M - 7; j++) {
                int tempBlack = 0;
                int tempWhite = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (!(black[k][l].equals(board[i+k][j+l]))) {
                            tempBlack++;
                        }
                        if(!(white[k][l].equals(board[i+k][j+l]))){
                            tempWhite++;
                        }
                    }
                }
                int minTemp = tempBlack > tempWhite ? tempWhite : tempBlack;
                min = min > minTemp ? minTemp : min;
            }
        }
        System.out.println(min);

    }
}
