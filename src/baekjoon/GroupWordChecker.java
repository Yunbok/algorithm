package baekjoon;

import java.util.Scanner;

public class GroupWordChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int wordCount = sc.nextInt();
        String[] wordArr = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            wordArr[i] = sc.next();
        }

        for (String word : wordArr) {
            answer += checkDuplicateChar(deleteConsecutiveChar(word));
        }
        System.out.println(answer);

    }

    private static String deleteConsecutiveChar(String word) {
        char[] wordArr = word.toCharArray();
        char targetSpell = wordArr[0];
        StringBuilder sb = new StringBuilder();
        sb.append(targetSpell);

        for (int i = 1; i < wordArr.length; i++) {
            if (targetSpell == wordArr[i]){
                continue;
            }
            sb.append(wordArr[i]);
            targetSpell = wordArr[i];
        }
        return sb.toString();
    }

    private static int checkDuplicateChar(String word) {

        long distinctLength = word.chars().mapToObj(c -> (char) c).distinct().count();
        long wordLength = word.length();

        if (distinctLength < wordLength) {
            return 0;
        }
        return  1;
    }
}
