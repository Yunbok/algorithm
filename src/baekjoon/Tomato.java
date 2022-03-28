package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato {
    static int M;
    static int N;
    static int[][] tomato;
    static final int[] xArr = {-1, 1, 0, 0};
    static final int[] yArr = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] mn = bf.readLine().split(" ");

        boolean zeroValue = false;
        M = Integer.parseInt(mn[0]);
        N = Integer.parseInt(mn[1]);
        int max = 0;
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] tempText = bf.readLine().split(" ");
            for  (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(tempText[j]);
                if (tomato[i][j] == 1 ) {
                    queue.add(new int[] { i , j});
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for  (int j = 0; j < M; j++) {
                max = Math.max(max, tomato[i][j]);
                if (tomato[i][j] == 0) {
                    zeroValue = true;
                }
            }
        }
        if (zeroValue) {
            System.out.println(-1);
        } else {
            System.out.println(max-1);
        }
    }

    public static void bfs(){

        while (!queue.isEmpty()) {

            int[] target = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = target[0] + xArr[i];
                int ny = target[1] + yArr[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(tomato[nx][ny] == 0){
                        tomato[nx][ny] = tomato[target[0]][target[1]] + 1;
                        queue.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}
