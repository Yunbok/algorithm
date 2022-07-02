package programmers_level1;

import java.util.Arrays;

public class Ponketmon {

    public static void main(String[] args) {

        solution(new int[] {3,1,2,3});
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int half = nums.length / 2;

        int[] distinctArr = Arrays.stream(nums).distinct().toArray();

        for (int val : distinctArr) {
            System.out.println(val);
        }

        return answer;
    }
}
