package baekjoon;

import java.util.*;

public class Deudbojab {

    public static void main(String[] args) {

        Set<String> duedSet = new HashSet<>();
        List<String> answerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            duedSet.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String bo = sc.next();
            if (duedSet.contains(bo)) {
                answerList.add(bo);
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.size());
        answerList.forEach(System.out::println);
    }
}
