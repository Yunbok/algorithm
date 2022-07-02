package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS2 {
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int R = Integer.parseInt(split[2]);

        list = new ArrayList[N+1];

        for (int i=1;i<=N;i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] tempSplit = bf.readLine().split(" ");
            int node1 = Integer.parseInt(tempSplit[0]);
            int node2 = Integer.parseInt(tempSplit[1]);

            list[node1].add(node2);
            list[node2].add(node1);
        }

        for(int i = 1;i <= N;i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
        bfs(R, N);
    }

    public static void bfs(int x, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        boolean[] visited = new boolean[N + 1];
        visited[x] = true;

        int cnt = 0;
        int[] order = new int[N + 1];
        while (!queue.isEmpty()) {
            int q = queue.poll();
            cnt++;
            order[q] = cnt;

            for (int i : list[q]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        for (int i
             = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }
}
