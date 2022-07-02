package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortInside {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = bf.readLine().toCharArray();

        Arrays.sort(chars);

        for (int i = chars.length -1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
