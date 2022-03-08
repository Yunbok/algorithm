package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Virus {
	static int comCnt;
	static int connectedComCnt;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] isInfected;
	static int infectedCnt = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		comCnt = sc.nextInt();
		
		connectedComCnt = sc.nextInt();
		
		isInfected = new boolean[comCnt+1];
		
		for ( int i = 0; i < comCnt+1; i++ ) {
			graph.add(new ArrayList<Integer>());
		}
		
		for ( int i = 0; i < connectedComCnt; i++ ) {
			int key = sc.nextInt();
			int value = sc.nextInt();
			
			graph.get(key).add(value);
			graph.get(value).add(key);
		}
		
		dfs(1);
		
		System.out.println(infectedCnt -1);
		
	}
	
	public static void dfs(int index) {
		isInfected[index] = true;
		infectedCnt++;
		for (int i: graph.get(index)) {
			if ( !isInfected[i] ) {
				dfs(i);
			}
		}
	}
}
