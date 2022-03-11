package programmers_level2;

import java.util.Arrays;

public class KNumber {
    public static void main(String[] args) {

        int[] numbers = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1},{1, 7, 3}};
        System.out.println(Arrays.toString(solution(numbers, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;

        for ( int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int indexToFind =  command[2];
            int[] sortedArr = new int[end - start +1];
            int j = 0;


            for (int i = start - 1 ;i < end; i++ ) {
                sortedArr[j] = array[i];
                j++;
            }
            Arrays.sort(sortedArr);
            answer[answerIndex++] = sortedArr[indexToFind-1];

        }
        return answer;
    }
}
