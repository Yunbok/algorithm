package baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ApartmentComplex {
	static int count;
	static int N;
	static int[][] map ;
	static boolean[][] hasChecked;
	static int[] xArr = {-1,1,0,0};
	static int[] yArr = {0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> result = new ArrayList<>();
		N = sc.nextInt();
		map = new int[N][N];
		hasChecked = new boolean[N][N];
		
		for ( int i = 0; i < N; i++ ) {
			String aptText = sc.next();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = aptText.charAt(j) - '0';
			}
		}
		
		count = 0;
		
		for ( int i = 0; i < N; i++ ) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !hasChecked[i][j] ) {
					count = 1;
					dfs(i,j);
					result.add(count);
				}
				
			}
		}
		result.sort(Comparator.naturalOrder());
		System.out.println(result.size());
		result.stream().forEach(System.out::println);
		
	}
	
	public static void dfs(int x, int y) {
		hasChecked[x][y] = true;
		
		for ( int i = 0; i < 4; i++ ) {
			int nx = x + xArr[i];
			int ny = y + yArr[i];
			
			if (nx >=0 && ny >= 0 &&nx < N && ny < N  && map[nx][ny] == 1 && !hasChecked[nx][ny]) {
				count++;
				dfs(nx,ny);
			}
			
		}
		
	}

}
