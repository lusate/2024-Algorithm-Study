package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수확 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][N + 1];
        int[] s = new int[N + 1];

        s[1] = nums[1];
        for (int i = 2; i <= N; i++) {
            s[i] = s[i-1] + nums[i]; // 벼 가치들의 합 1, 4, 5, 10, 12
        }
        for (int i = 1; i <= N; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]) + (s[j + i] - s[j - 1]);
            }
        }

        System.out.println(dp[1][N]);

    }
}
