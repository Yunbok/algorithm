package programmers_level3;

public class WayToSchool {

    public static void main(String[] args) {
        System.out.println(solution(3,4,new int[][] {{2,2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer;
        long[][] dp = new long[n + 1][m + 1];
        dp[1][1] = 1;

        for ( int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 1 && j == 1 ) {
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] ) % 1000000007;

            }
        }
        answer = (int) dp[n][m];

        return answer;
    }
}
