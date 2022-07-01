package programmers_level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerGrid {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

    }
    public int solution(int n, int[][] wires) {
        int answer = 9999999;

        for (int i = 0; i < wires.length; i++) {
            if (!graph.containsKey(wires[i][0])) {
                graph.put(wires[i][0], new ArrayList<>());
            }
            if (!graph.containsKey(wires[i][1])) {
                graph.put(wires[i][1], new ArrayList<>());
            }

            graph.get(wires[i][1]).add(wires[i][0]);
            graph.get(wires[i][0]).add(wires[i][1]);
        }

        for (int[] arr : wires) {
            answer = Math.min(answer, Math.abs(dfs(arr[0], arr[0], arr[1]) - dfs(arr[1], arr[1], arr[0])));

        }

        return answer;
    }

    public int dfs(int index,int prevNum, int vanNumber) {

        List<Integer> list = graph.get(index);
        int count = 0;
        for (int i = 0;i < list.size(); i++) {
            if (list.get(i) != prevNum && list.get(i) != vanNumber) {
                count++;
                count += dfs(list.get(i), index, vanNumber);
            }
        }
        return count;
    }
}
