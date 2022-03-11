package programmers_level2;

import java.util.*;

public class HIndex {

    public static void main(String[] args) {

        //기본 테스트 케이스
        int[] citations = {3,0,6,1,5};
        // H-Index 의 함정 : H index 는 총 논문갯수보다 작거나 같고, 대부분 배열 안에있는 숫자가 아니다.
        int[] citations2 = {88,89};
        System.out.println(solution(citations));
        System.out.println(solution(citations2));

    }

    public static int solution(int[] citations) {
        int h = 0;
        int countIndex = 0;
        long count = 0;

        Arrays.sort(citations);

        while ( count >= h) {
            if(citations[countIndex] >= h) {
                h++;
            } else {
                countIndex++;
                if ( countIndex == citations.length) {
                    break;
                }
            }
            count = citations.length - (countIndex);
        }


        return h-1;
    }

}
