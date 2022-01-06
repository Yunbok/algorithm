package programmers_level3;

public class TrafficCount {

    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        String[] lines2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        solution(lines2);
    }

    public static int solution(String[] lines) {
        int answer = 0;

        int[] startMillisec = new int[lines.length];
        int[] endMillisec = new int[lines.length];

        for ( int i = 0 ; i <lines.length ; i++ ) {
            int startMs = 0;
            int endMs = 0;

            String[] timeArr = lines[i].split(" ");
            // s 제거 후 밀리초로 변환
            String[] hms = timeArr[1].split(":"); // 21:00:02.066
            endMs += Integer.parseInt(hms[0]) * 60 * 60 * 1000; // 시간 밀리초 구하기
            endMs += Integer.parseInt(hms[1]) * 60 * 1000; // 분 밀리초 구하기
            endMs += (int) (Double.parseDouble(hms[2]) * 1000); // 시간 밀리초 구하기

            //시작시간 = 응답완료시간 S - 처리시간 T + 1ms
            startMs = endMs - (int)( Double.parseDouble(timeArr[2].substring(0 , timeArr[2].length()-1)) * 1000) ;

            startMillisec[i] = startMs;
            endMillisec[i] = endMs;
        }

        for ( int j = 0; j<lines.length; j++ ) {
            int cnt = 0;
            int cnt2 = 0;
            int startTime = startMillisec[j];
            int endTime = endMillisec[j];

            // 시작시간 기준 + 1초 박스
            for (int s = 0; s < lines.length; s++) {
                cnt = cnt + rangeCheck(startMillisec[s] , startTime , endMillisec[s],startTime + 1000);
                cnt2 = cnt2 + rangeCheck(startMillisec[s] , endTime , endMillisec[s],endTime  + 1000);
            }
            answer = maxIntReturn(answer ,cnt,cnt2);
        }
        return answer;
    }
    public static int rangeCheck ( int start , int startPoint , int end , int endPoint) {
        if ( start >= startPoint  &&  start < endPoint){
            return 1;
        } else if (end >= startPoint  &&  end < endPoint) {
            return 1;
        } else if ( start <= startPoint  &&  end >= endPoint ) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int maxIntReturn ( int a, int b , int c) {
        int n = b > c ? b : c;
        return a > n ? a : n;
    }
}
