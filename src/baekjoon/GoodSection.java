package baekjoon;

import java.util.*;

public class GoodSection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int[] S = new int[L];
        int N = 0;
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        boolean isEqual = false;

        for (int i = 0; i < S.length; i++) {
            S[i] = sc.nextInt();
        }
        N = sc.nextInt();

        high.add(1001);
        low.add(0);
        for (int i = 0; i < S.length; i++) {

            if (S[i] > N) {
                high.add(S[i]);
            } else if (S[i] < N) {
                low.add(S[i]);
            } else {
                isEqual = true;
                break;
            }
        }

        if (high.size() == 0 || low.size() == 0) {
            isEqual = true;
        }

        if (!isEqual) {
            Collections.sort(high);
            Collections.sort(low);

            int left = N - low.get(low.size() - 1) - 1 ;
            int right = high.get(0) - N - 1;

            System.out.println(left + right + (left * right));

        } else {
            System.out.println(0);
        }
    }
}
