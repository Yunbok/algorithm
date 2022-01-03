package programmers_level1;

import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int checkNum = 0;

        for (int lotto : lottos) {
            if ( lotto == 0) {
                zeroCnt++;
            } else {
                if( Arrays.stream(win_nums).anyMatch(x -> x == lotto) ) {
                    checkNum++;
                }
            }
        }

        int[] answer = {lottoRank(checkNum+zeroCnt), lottoRank(checkNum)};
        return answer;
    }


    public int lottoRank(int cnt) {
        int rank = 6;
        if (cnt == 6) {
            rank = 1;
        } else if (cnt == 5) {
            rank = 2;
        } else if (cnt == 4) {
            rank = 3;
        } else if (cnt == 3) {
            rank = 4;
        } else if (cnt == 2) {
            rank = 5;
        }

        return rank;
    }
}