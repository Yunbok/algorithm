package baekjoon;

import java.util.*;

public class MeetingRoom {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] timeArr = new int[N][2];

        for (int i = 0; i < N; i++) {
            int sTime = sc.nextInt();
            int eTime = sc.nextInt();

            timeArr[i][0] = sTime;
            timeArr[i][1] = eTime;

        }
        Arrays.sort(timeArr ,(time1 ,time2) -> {
            if (time1[1] == time2[1]) {
                return Integer.compare(time1[0],time2[0]);
            } else {
                return Integer.compare(time1[1],time2[1]);
            }
        });
        int result = 1;
        int standard = timeArr[0][1];
        for (int i = 1 ; i < N ; i++) {
            if (standard <= timeArr[i][0]) {
                result++;
                standard = timeArr[i][1];
            }
        }
        System.out.println(result);
    }
}
