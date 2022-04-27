package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();
        int wordNum = sc.nextInt();

        for (int i = 0; i < wordNum; i++) {
            wordList.add(sc.next());
        }

        wordList.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }).distinct().forEach(System.out::println);
    }
}
