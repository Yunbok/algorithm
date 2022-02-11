package baekjoon;

public class Function_sum {

    long sum(int[] a) {

        long ans = 0;
        for ( int i : a) {
            ans += (long) i;
        }
        return ans;
    }
}
