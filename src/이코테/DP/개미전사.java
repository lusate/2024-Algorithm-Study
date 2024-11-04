package 이코테.DP;

public class 개미전사 {
    public int solution(int n, int[] ant) {
        int answer = 0;
        int[] dp = new int[100];
        dp[0] = ant[0];
        dp[1] = Math.max(ant[0], ant[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + ant[i]);
        }

        answer = dp[n-1];
        return answer;
    }
    public static void main(String[] args) {
        개미전사 T = new 개미전사();
        System.out.println(T.solution(4, new int[]{1, 3, 1, 5}));
    }
}
