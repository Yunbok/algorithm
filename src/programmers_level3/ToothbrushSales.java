package programmers_level3;

import java.util.HashMap;

public class ToothbrushSales {
    static int[] answer;
    static String[] referral1;
    static HashMap<String,Integer> enrollMap = new HashMap<String,Integer>();


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] enroll = 	{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral ={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller ={"young", "john", "tod", "emily", "mary"};
        int[] amount ={12, 4, 2, 5, 10};

        solution(enroll,referral,seller, amount);
    }


    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        referral1 = referral;
        answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++) {
            enrollMap.put(enroll[i], i);
        }

        for(int i=0; i < seller.length; i++ ) {
            int index = enrollMap.get(seller[i]);
            distribution(index,amount[i]*100);
        }

        return answer;
    }
    public static void distribution(int index, int money) {
        int upMoney = 0;
        int myMoney = 0;
        if ( money > 0) {
            upMoney = (int) (money * 0.1);
            myMoney = money - upMoney;
            if ( "-".equals(referral1[index]) ) {
                answer[index] += myMoney;
            } else if ( upMoney < 1) {
                answer[index] += money;
            } else {
                answer[index] += myMoney;
                distribution(enrollMap.get(referral1[index]),upMoney);
            }
        }
    }

}
