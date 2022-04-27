package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class FindString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        int[] spellArr = new int[26];
        char[] textArr = text.toCharArray();

        Arrays.fill(spellArr, -1);
        int count = 0;
        for (char word : textArr) {
            if (spellArr[word - 97] == -1 ) {
                spellArr[word - 97] = count;
            }
            count++;
        }

        for (int i : spellArr) {
            System.out.print(i + " ");
        }

    }
}
