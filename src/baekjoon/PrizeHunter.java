package baekjoon;

import java.util.Scanner;

public class PrizeHunter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for ( int i = 0; i < T; i++ ) {
            int money = 0;
            money += prizeMoney2017(sc.nextInt());
            money += prizeMoney2018(sc.nextInt());
            System.out.println(money);
        }

    }

    public static int prizeMoney2018 (int rank) {
        int prizeMoney = 5120000;

        if (rank == 1) {
            return prizeMoney;
        } else if ( rank == 2 || rank == 3) {
            return prizeMoney / 2 ;
        } else if ( rank >= 4 && rank <= 7) {
            return prizeMoney / 4;
        } else if ( rank >= 8 && rank < 16) {
            return prizeMoney / 8;
        } else if ( rank >= 16 && rank < 32) {
            return prizeMoney / 16;
        } else {
            return 0;
        }
    }

    public static int prizeMoney2017 (int rank) {

        if (rank == 1) {
            return 5000000;
        } else if ( rank == 2 || rank == 3) {
            return 3000000;
        } else if ( rank >= 4 && rank < 7) {
            return 2000000;
        } else if ( rank >= 7 && rank < 11) {
            return 500000;
        } else if ( rank >= 11 && rank < 16) {
            return 300000;
        } else if ( rank >= 16 && rank < 22) {
            return 100000;
        } else {
            return 0;
        }
    }
}
