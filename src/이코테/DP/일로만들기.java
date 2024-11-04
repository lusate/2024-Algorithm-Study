package 이코테.DP;

import java.io.IOException;

public class 일로만들기 {
    public int solution(int x) {
        int answer = 0;
        int[] dp = new int[x+1];

        dp[1] = 0;
        for (int i = 2; i <= x; i++) { // i를 x라 생각
            dp[i] = dp[i - 1] + 1;

            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1); // 연산 하나 추가를 위해 1을 더함
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        answer = dp[x];
        return answer;
    }
    public static void main(String[] args) throws IOException {
        일로만들기 T = new 일로만들기();
        System.out.println(T.solution(26)); // 3
//        System.out.println(T.solution(4)); // 2
    }
}
