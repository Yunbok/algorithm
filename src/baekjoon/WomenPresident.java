package baekjoon;

import java.util.Scanner;

public class WomenPresident {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for ( int i = 0; i < T; i++ ){
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(residentCount(k,n));
        }
    }

    public static int residentCount(int floor , int roomNum) {
        int[][] apt = new int[1+floor][roomNum];

        for (int i = 0; i <= floor; i++) {
            for (int j = 0; j < roomNum; j++) {
                if ( i == 0 ) {
                    apt[i][j] = j+1;
                    continue;
                }
                if ( j == 0 ) {
                    apt[i][j] = 1;
                    continue;
                }

                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        return apt[floor][roomNum-1];
    }
}
