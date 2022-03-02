package baekjoon;

import java.util.*;

public class Friend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Integer,Set<Integer>> friendMap = new HashMap<>();
        int max = -1;

        for ( int i = 0; i < N; i++) {
            String tempText = sc.next();
            Set<Integer> friendSet = new HashSet<>();
            for ( int j =0; j < N; j++ ) {
                if (tempText.charAt(j) == 'Y') {
                    friendSet.add(j);
                }
            }
            friendMap.put(i,friendSet);
        }

        for ( int i = 0; i < N; i++) {
            Set<Integer> mergedSet = new HashSet<>();
            mergedSet.addAll(friendMap.get(i));
            for ( int j : friendMap.get(i)) {
                mergedSet.addAll(friendMap.get(j));
            }
            max = Math.max(max,mergedSet.size());
        }
        if ( max != 0 ) {
            max -= 1;
        }
        System.out.println(max);
    }
}
