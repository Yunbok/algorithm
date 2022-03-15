package baekjoon;

import java.util.*;

public class organicCabbageBFS {
    static int T;//테스트케이스
    static int M;//배추밭 가로길이
    static int N;//배추밭 세로길이
    static int K;//배추갯수
    static int result;
    static List<Cabbage> cabbageList;
    static boolean[][] checkMap;
    static int[] xArr = { -1, 1, 0, 0};
    static int[] yArr = { 0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for ( int testCase = 0; testCase < T; testCase++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            result = 0;
            cabbageList = new ArrayList<>();
            checkMap = new boolean[M][N];
            for ( int i = 0; i < K; i++) {
                cabbageList.add(new Cabbage(sc.nextInt(),sc.nextInt()));
            }

            for ( int i = 0; i < K; i++ ) {
                Cabbage c = cabbageList.get(i);
                if (!checkMap[c.getX()][c.getY()]) {
                    result++;
                    bfs(c);
                }
            }
            System.out.println( result);
        }
    }

    public static void bfs(Cabbage cabbage) {
        Queue<Cabbage> queue = new LinkedList<>();
        queue.add(cabbage);

        while (!queue.isEmpty()) {
            Cabbage targetCabbage = queue.poll();
            checkMap[targetCabbage.getX()][targetCabbage.getY()] = true;

            for (int i = 0; i < 4; i++) {
                int nx = targetCabbage.getX() + xArr[i];
                int ny = targetCabbage.getY() + yArr[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    Cabbage tempCabbage = new Cabbage(nx, ny);
                    for (int j = 0; j < K; j++) {
                        if (cabbageList.get(j).equals(tempCabbage) && !checkMap[nx][ny]) {
                            queue.add(tempCabbage);
                        }
                    }
                }
            }
        }
    }
}
class Cabbage {
    private int x;
    private int y;

    Cabbage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean equals(Cabbage cabbage) {

        if ( this.x == cabbage.getX() && this.y == cabbage.getY()) {
            return true;
        }

        return false;
    }
}
