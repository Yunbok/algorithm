package programmers_level2;

import java.util.ArrayList;

public class FunctionDev {


    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int prevProgres = 0;
        int cnt = 0;

        for ( int i = 0 ; i < progresses.length ; i++ ) {
            int base = 100 - progresses[i];
            int quot = base / speeds[i];
            int remain =  base % speeds[i];

            if ( remain > 0 ) {
                quot++;
            }
            if ( prevProgres == 0 ) {
                prevProgres = quot;
            }

            if ( prevProgres >= quot ) {

                cnt++;
                continue;
            } else {
                resultList.add(cnt);
                prevProgres = quot;
                cnt = 1;
            }

        }
        if( cnt != 0) {
            resultList.add(cnt);
        }
        int[] answer = new int[resultList.size()];

        for ( int i = 0; i < resultList.size() ; i++ ) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
