package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * i는 연산 단계로 어디까지 계산했는지를 나타냄
         * j는 i까지 연산했을 때의 연산 결과를 나타냄
         * 그래서 dp는 i번째까지 계산했을 때 연산 결과가 나온 가지 수를 나타냄 즉 i = 1, j = 13 이라면 i번째까지 연산했을 때 결과 j가 나온 가지 수
         * plus와 minus는 현재까지 계산된 결과에서 바로 다음 연산을 하는 결과를 나타냄
         * 나는 처음에 dp를 1차원 배열로 i번째 연산을 했을 때 가지 수로 해서 연산 결과 j를 뽑아낼 수가 없었음
         */
        long[][] dp = new long[N + 1][21];
        dp[1][arr[1]] = 1;

        for (int i = 1; i <= N - 2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] != 0) { // 0인 경우 더하거나 빼지 않아도 되기 때문에 제외
                    int plus = j + arr[i + 1];
                    int minus = j - arr[i + 1];

                    // plus와 minus가 된 경우로 가지 수가 dp에 저장되어 있으므로 누적해줘야 함.
                    if (plus >= 0 && plus <= 20) {
                        dp[i + 1][plus] += dp[i][j];
                    }
                    if(minus >= 0 && minus <= 20) {
                        dp[i + 1][minus] += dp[i][j];
                    }
                }
            }
        }
        int last = arr[N];
        answer = dp[N - 1][last];
        System.out.println(answer);
    }
}
/*
11
8 3 2 4 8 7 2 4 0 8 8

40
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1
 */