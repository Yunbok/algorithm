package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M;
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < N; i++ ) {
            numberList.add(sc.nextInt());
        }
        numberList.sort(Integer::compareTo);

        M = sc.nextInt();
        for (int i = 0; i < M; i++ ) {

            int target = sc.nextInt();
            int start = 0;
            int end = numberList.size() - 1;
            int mid = (end + start) / 2;
            boolean discovered = false;

            while (start <= end) {
                if (numberList.get(mid) == target) {
                    discovered = true;
                    break;
                } else if ( numberList.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = (end + start) / 2;
            }

            if (discovered) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
