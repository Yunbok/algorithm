package programmers_level2;

public class LargestSquare {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
    }

    public static int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];

        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if(board[i-1][j-1] != 0) {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer * answer;
    }


    private static int min(int a ,int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
