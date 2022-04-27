package baekjoon;

import java.util.*;

public class Virus2 {

    static Map<Integer, ArrayList> graph = new HashMap<>();
    static boolean[] isVisited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int computer = sc.nextInt();
        int nodeNum = sc.nextInt();
        isVisited = new boolean[computer + 1];

        for (int i = 0; i < nodeNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isVisited[1] = true;
        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            List<Integer> targetList = graph.get(node);

            for (Integer target : targetList) {

                if (isVisited[target]) {
                    continue;
                }
                isVisited[target] = true;
                queue.add(target);
                count++;
            }

        }
        System.out.println(count);
    }

}
