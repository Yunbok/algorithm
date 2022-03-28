package baekjoon;

import java.util.*;

public class organicCabbage {
    static int T;//테스트케이스
    static int M;//배추밭 가로길이
    static int N;//배추밭 세로길이
    static int K;//배추갯수
    static int result;
    static List<Cabbage> cabbageList;
    static boolean[] check;
    static int[] xArr = { -1, 1, 0, 0};
    static int[] yArr = { 0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for ( int testCase = 0; testCase < T; testCase++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            cabbageList = new ArrayList<>();
            check = new boolean[K];
            for ( int i = 0; i < K; i++) {
                cabbageList.add(new Cabbage(sc.nextInt(),sc.nextInt()));
            }

            for ( int i = 0; i < K; i++ ) {
                if (!check[i]) {
                    bfs(i);
                }
            }
        }
    }
    public static void bfs(int index) {
        check[index] = true;

        Cabbage cabbage = cabbageList.get(index);

        for ( int i = 0; i < 4; i++) {
            int nx = cabbage.getX() + xArr[i];
            int ny = cabbage.getY() + yArr[i];
            Cabbage tempCabbage = new Cabbage(nx,ny);
            if (nx >= 0 && nx < M && ny >= 0 && ny < N ) {
                for ( int j = 0; j < K; j++) {
                    if (cabbageList.get(j).equals(tempCabbage) && !check[j]) {

                    }
                }
            }
        }


    }

    static class Cabbage {
        int x;
        int y;

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
}
