package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class SayMiddle {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lowerQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upperQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < N; i++) {
            int nextVal = Integer.parseInt(br.readLine());

            if( upperQueue.size() == lowerQueue.size()) {
                lowerQueue.add(nextVal);
            } else {
                upperQueue.add(nextVal);
            }

            if (!upperQueue.isEmpty() && lowerQueue.peek() > upperQueue.peek()) {
                upperQueue.add(lowerQueue.poll());
                lowerQueue.add(upperQueue.poll());
            }
            sb.append(lowerQueue.peek()+ "\n");
        }
        System.out.println(sb);
    }
}




