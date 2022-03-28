package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExploration {
	static int N;
	static int M;
	static boolean[][] check;
	static int[][] maze;
	static int[] xArr = {-1, 1, 0, 0};
	static int[] yArr = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String row = bf.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}
		
		check[0][0] = true;
		bfs(0,0);

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()){
			
			int[] targetNode = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = targetNode[0] + xArr[i];
				int ny = targetNode[1] + yArr[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (maze[nx][ny] > 0 && !check[nx][ny]) {
						maze[nx][ny] = maze[targetNode[0]][targetNode[1]] + 1;
						check[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		System.out.println(maze[N-1][M-1]);
	}
}
