package programmers_level3;

public class WordConversion {

    static String[] cWords;
    static  boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution("hit","cog",new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {

        cWords = words;
        visit = new boolean[words.length];

        dfs(begin,target,0);

        return answer;
    }

    public static void dfs(String begin, String target, int num) {

        if(begin.equals(target)){
            answer = num;
            return;
        }

        for ( int i = 0; i < cWords.length; i++) {
            if (visit[i]) {
                continue;
            }
            int count = 0;
            for ( int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != cWords[i].charAt(j) ) {
                    count++;
                }
            }
            if ( count == 1){
                visit[i] = true;
                dfs(cWords[i],target, num+1);
                visit[i] = false;
            }
        }
    }
}
