package baekjoon;

import java.util.Scanner;

public class Lost_Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        String[] numArr = text.split("\\-");
        int result = 0;
        for (int i = 0; i < numArr.length; i++) {

            String[] plusArr = numArr[i].split("\\+");
            int plusNum = 0;
            for (int j= 0 ; j < plusArr.length; j++) {
                plusNum += Integer.parseInt(plusArr[j]);

            }
            if (i == 0) {
                result += plusNum;
            } else {
                result -= plusNum;
            }
        }
        System.out.println(result);
    }
}
