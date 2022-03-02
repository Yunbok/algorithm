package baekjoon;

import java.util.*;

public class Stick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int stickLength = 64;
        List<Integer> stickList = new LinkedList<Integer>();
        stickList.add(64);
        while ( X != stickLength) {
            int tempA = stickList.get(stickList.size()-1) / 2 ;
            stickList.remove(stickList.size()-1);
            if (stickLength - tempA < X) {
                stickList.add(tempA);
            } else {
                stickLength -= tempA;
            }
            stickList.add(tempA);
        }
        System.out.println(stickList.size());
    }
}
