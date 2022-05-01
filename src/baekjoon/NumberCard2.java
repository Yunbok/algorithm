package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCard2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] positiveNum = new int[10000001];
        int[] negativeNum = new int[10000001];
        int N = Integer.parseInt(bf.readLine());
        int[] sanggeunCards = stringToIntArr(bf.readLine());

        for (int i : sanggeunCards) {
            if ( i > 0) {
                positiveNum[i]++;
                continue;
            }
            negativeNum[Math.abs(i)]++;
        }
        int M = Integer.parseInt(bf.readLine());
        int[] questionCards = stringToIntArr(bf.readLine());
        int[] targetArr;
        StringBuilder sb = new StringBuilder();

        for (int targetNum : questionCards) {
            if (targetNum > 0) {
                targetArr = positiveNum;
            } else {
                targetArr = negativeNum;
            }

            int absTarget = Math.abs(targetNum);
            int start = 0;
            int end = targetArr.length - 1;
            int mid = (end + start) / 2;

            while (start <= end) {
                if (mid == absTarget) {
                    break;
                } else if (mid > absTarget) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = (end + start) / 2;
            }

            sb.append(targetArr[mid]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int[] stringToIntArr(String numbers) {
        String[] splitNumbers = numbers.split(" ");
        int[] numberArr = new int[splitNumbers.length];

        for (int i = 0; i < splitNumbers.length; i++) {
            numberArr[i] = Integer.parseInt(splitNumbers[i]);
        }

        return numberArr;
    }

}
