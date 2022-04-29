package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue queue = new PriorityQueue();

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
