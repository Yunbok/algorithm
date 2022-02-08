package baekjoon;

import java.util.*;

public class DFSandBFS {

    static boolean[] dfsVisitArr;
    static boolean[] bfsVisitArr;
    static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        dfsVisitArr = new boolean[N+1];
        bfsVisitArr = new boolean[N+1];

        for ( int i = 0; i < N+1; i++ ){
            graph.add(new ArrayList<>());
        }
        for ( int i = 0; i < M; i++ ){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for ( int i = 0; i < N+1; i++ ){
            Collections.sort(graph.get(i));

        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int index) {
        System.out.print(index +  " ");
        dfsVisitArr[index] = true;

        for ( int value : graph.get(index)) {
            if(!dfsVisitArr[value]) {
                dfs(value);
            }
        }
    }
    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        bfsVisitArr[index] = true;
        queue.add(index);

        while(queue.size() != 0) {
            index = queue.poll();
            System.out.print(index + " ");

            for( int i : graph.get(index)) {
                if(!bfsVisitArr[i]) {
                    bfsVisitArr[i] = true;
                    queue.add(i);
                }
            }

        }
    }
}
