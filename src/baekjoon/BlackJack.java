package baekjoon;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cardCnt = sc.nextInt();
        int maxValue = sc.nextInt();
        int[] cardDeck = new int[cardCnt];
        int result = 0;
        boolean flag = false;

        for ( int i = 0; i < cardCnt; i++) {
            cardDeck[i] = sc.nextInt();
        }


        for ( int i = 0; i < cardCnt-2; i++) {
            for ( int j = i+1;j < cardCnt-1; j++) {
                for ( int k = j+1; k < cardCnt; k++) {
                    int cardSum = cardDeck[i] + cardDeck[j] + cardDeck[k];
                    if ( cardSum < maxValue) {
                        result = Math.max(result , cardSum);
                    } else if (cardSum == maxValue ) {
                        result = maxValue;
                        flag = true;
                        break;
                    }

                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.print(result);
    }
}
