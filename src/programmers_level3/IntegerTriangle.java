package programmers_level3;

public class IntegerTriangle {

    public static void main(String[] args) {

        System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));

    }

    public static int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int[][] dp;
        int height = triangle.length;
        int width = triangle[height -1].length;
        dp = new int[height][width];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if ( j == 0 ) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];

                } else if (j == triangle[i].length - 1 ) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1] , dp[i - 1][j]);

                }

                if(i == height - 1) {
                    answer = Math.max(answer,dp[i][j]);

                }
            }
        }

        return answer;
    }
}
