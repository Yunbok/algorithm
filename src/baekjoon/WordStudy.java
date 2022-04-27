package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordStudy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next().toUpperCase();
        char[] wordArr = word.toCharArray();
        int[] spellArr = new int[26];
        List<Character> answerList = new ArrayList<>();
        int max = -1;
        for (char charWord : wordArr) {
            spellArr[charWord - 65]++;
            max = Math.max(spellArr[charWord - 65], max);
        }

        for (int i = 0; i < spellArr.length; i++) {
            if (spellArr[i] == max) {
                answerList.add((char)(i + 65));
            }
        }

        if (answerList.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(answerList.get(0));
        }
    }
}
