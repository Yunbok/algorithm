package programmers_level2;

import java.util.Arrays;

public class BiggestNumber {

    public static void main(String[] args) {

        // 문자열을 내림차순으로 정렬하게되면 9 , 5, 34 , 30 ,3 이되어
        // 예상값은 9534303 이지만 정답은 9534330 이다
        // 문자열을 정렬할때 앞뒤 두개를 더해서 비교하면 자리수별로 큰것을 더 앞으로 배치할수있다.

        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));

        int[] numbers2 = {9999,9998,9997,9996,7777,999,98,97,9,89,10};
        System.out.println(solution(numbers2));
    }


    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, (a, b) -> (b+a).compareTo(a+b));

        for (String stringNumber : stringNumbers) {
            sb.append(stringNumber);
        }

        if ("0".equals(stringNumbers[0])) {
            return "0";
        }

        return sb.toString();
    }

}
