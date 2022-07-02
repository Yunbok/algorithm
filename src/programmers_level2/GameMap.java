package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

    public boolean[][] visited;
    public int[] xArr = {-1, 1, 0, 0};
    public int[] yArr = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];

        answer = bfs(maps);
        return answer;
    }

    public int bfs(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;
        int N = maps.length;
        int M = maps[0].length;

        while (!queue.isEmpty()) {

            Node target = queue.poll();

            for (int i = 0;i < 4; i++) {
                int nx = target.getX() + xArr[i];
                int ny = target.getY() + yArr[i];

                if (nx >= 0 && nx < N
                        && ny >= 0 && ny < M
                        && !visited[nx][ny]
                        && maps[nx][ny] > 0
                ) {
                    maps[nx][ny] = maps[target.getX()][target.getY()] + 1;
                    visited[nx][ny] = true;

                    queue.add(new Node(nx, ny));

                }
            }
        }
        if (maps[N - 1][M - 1] == 1) {
            return -1;
        } else {
            return maps[N - 1][M - 1];
        }

    }
}
class Node {
    private int x;
    private int y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
