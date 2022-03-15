package programmers_level3;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class Network {

    static boolean[][] visit;

    public static void main(String[] args) {

        int[][] computers = {{1,1,0}, {1,1,0},{0,0,1}};
        int n = 3;
        System.out.println(solution(n,computers));

    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j]==1 && !visit[i][j]) {
                    answer++;
                    visit[i][j] = true;
                    bfs(i,computers,n);
                }

            }
        }
        return answer;
    }

    public static void bfs(int x,int[][] computers , int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {

            int target = queue.poll();
            for ( int i = 0; i < n; i++) {
                if (!(target == i)) {
                    if (computers[target][i] == 1 && !visit[target][i]) {
                        queue.add(i);

                    }
                }

                visit[target][i] = true;
            }

        }
    }
}
