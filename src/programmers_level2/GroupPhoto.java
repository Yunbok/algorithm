package programmers_level2;

import java.util.*;

public class GroupPhoto {


    static Map<Character,Integer> friends;
    static boolean[] isChecked;
    static int[] list;
    static String[] sData;
    static int answer = 0;

    public static void main(String[] args) {

        solution(2,new String[] {"N~F=0", "R~T>2"});
    }

    public static int solution(int n, String[] data) {

        sData = data;
        friends = new HashMap<>();
        isChecked = new boolean[8];
        list = new int[8];

        friends.put('A',0);
        friends.put('C',1);
        friends.put('F',2);
        friends.put('J',3);
        friends.put('M',4);
        friends.put('N',5);
        friends.put('R',6);
        friends.put('T',7);
        perm(0);

        return answer;
    }

    private static void perm(int cnt) {
        if (cnt == 8) {
            if(isOk()){
                //최종적으로 8명이 다 리스트에 담겼을때 주어진 조건을 검사해서 +1
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isChecked[i]) {
                //이미 앞에 줄서있는 프렌즈는 제외하고 탐색
                continue;
            }

            isChecked[i] = true;
            list[cnt] = i;
            // 다음 노드 탑색색
           perm(cnt + 1);
            // 방문했던곳을 해제해주지않으면 한번 탐색후 끝나버린다.
            isChecked[i] = false;
        }

    }

    private static boolean isOk(){
        for (String sDatum : sData) {
            int friendX = list[friends.get(sDatum.charAt(0))];
            int friendY = list[friends.get(sDatum.charAt(2))];
            char sign = sDatum.charAt(3);
            int num = sDatum.charAt(4) - '0';
            //두수 사이의 거리 절대값 ex ) 0 1 일경우 1이 되는데 문제상으로는 붙어있으면 거리가 0이기때문에 -1을해줘야한다
            int absDistance = Math.abs(friendX - friendY) - 1;

            if (sign == '=') {
                if (absDistance != num) {
                    return false;
                }
            } else if (sign == '<') {
                if (absDistance >= num) {
                    return false;
                }

            } else if (sign == '>') {
                if (absDistance <= num) {
                    return false;
                }
            }
        }
        return true;
    }
}
