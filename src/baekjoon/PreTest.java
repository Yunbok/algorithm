package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class PreTest {

    static final int[] xArr = {-1, 1, 0, 0};
    static final int[] yArr = {0, 0, -1, 1};
    static boolean[][] visitArr;
    static String[][] matrix;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> answerList = new ArrayList<>();
        //행렬크기 N
        int N = Integer.parseInt(sc.nextLine().trim());
        matrix = new String[N][N];
        visitArr = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String[] readLine = sc.nextLine().split(" ");
            matrix[i] = readLine;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visitArr[i][j]) {
                    continue;
                }
                if (matrix[i][j].equals("0")) {
                    continue;
                }

                answerList.add(bfs(i, j, N));
            }
        }

        printAnswer(answerList);
    }
    private static void printAnswer(final List<Integer> answerList) {
        System.out.println(answerList.size());
        System.out.println(answerList.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static int bfs(final int x, final int y, final int N) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int areaCount = 0;

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node.getX() + xArr[i];
                int nextY = node.getY() + yArr[i];

                if (0 > nextX || 0 > nextY || N <= nextX || N <= nextY) {
                    continue;
                }
                if (visitArr[nextX][nextY]) {
                    continue;
                }
                if (matrix[nextX][nextY].equals("0")) {
                    continue;
                }

                areaCount++;
                visitArr[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));
            }
        }
        return areaCount;
    }
}

class Node {
    private final int x;
    private final int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
