package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = stoi(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < t; k++) {
            int n = stoi(br.readLine());
            int[] coin = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                coin[i] = stoi(st.nextToken());
            }

            int m = stoi(br.readLine()); // 만들어야 할 금액
            int[] dp = new int[m + 1]; // index원을 가지고 i개로 m을 만들 수 있는 방법의 수
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j - coin[i] > 0) {
                        dp[j] += dp[j - coin[i]];
                    } else if (j - coin[i] == 0) { // 초반을 위한 조건
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[m] + "\n");
        }

        System.out.println(sb);
    }
}
