package programmers_level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {

    public boolean[] visited;
    public List<String> routeList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(routeList);

        answer = routeList.get(0).split(" ");


        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            routeList.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {

            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
