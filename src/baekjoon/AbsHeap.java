package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsHeap {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
              return o1.compareTo(o2);
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(bf.readLine());
            if (inputNum == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
                continue;
            }
            queue.add(inputNum);
        }
    }
}
