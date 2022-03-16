package programmers_level1;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

    public static void main(String[] args) {

        System.out.println(solution(new int[] {1,2,3,4,5}));
    }


    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        int[] firstMathGiver = {1,2,3,4,5};
        int[] secondMathGiver = {2,1,2,3,2,4,2,5};
        int[] thirdMathGiver = {3,3,1,1,2,2,4,4,5,5};

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < answers.length; i++ ) {
            if (answers[i] == firstMathGiver[i % 5]) {
                score[0]++;
            }

            if (answers[i] == secondMathGiver[i % 8]) {
                score[1]++;
            }

            if (answers[i] == thirdMathGiver[i % 10]) {
                score[2]++;
            }
        }

        int max = Math.max(score[0], Math.max(score[1],score[2]));
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                answerList.add(i+1);
            }
        }

        answer = answerList.stream().mapToInt(i -> i).toArray();


        return answer;
    }
}
