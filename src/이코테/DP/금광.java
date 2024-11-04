package 이코테.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int answer = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    // 범위를 위해
                    int rightUp = (i == 0) ? 0 : dp[i - 1][j - 1];
                    int right = dp[i][j - 1];
                    int rightDown = (i == n - 1) ? 0 : dp[i + 1][j - 1];

                    dp[i][j] += Math.max(rightDown, Math.max(rightUp, right));
                }
            }

            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, dp[i][m - 1]);
            }

            System.out.println(answer);
        }
    }
}

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */