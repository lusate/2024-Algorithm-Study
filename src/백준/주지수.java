package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp 배열을 구함 ->
 * (x1, y1) ~ (x2, y2) 직사각형에 존재하는 값들의 합은
 * dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
 */
public class 주지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] populations = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp는 첫 지점부터 dp[i][j]까지의 인구 수를 모두 더한 값을 넣는다.
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + populations[i][j];
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        /**
         * dp[x2][y2]는 처음부터 (x2, y2) 지점까지 모두 더한 값이기 때문에 만약 처음부터가 아닌
         * 다른 위치부터 더했다면 이 값들을 빼줘야 한다.
         * 빼줄 때 dp[x1 - 1][y1 - 1] 이 위치는 한번 더 빼주기 때문에 마지막에 더해줘야 결과값이 나온다.
         */
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(result).append("\n"); // x, y 값들을 다 넣은 후에 sb를 뽑기 위함.
        }

        System.out.println(sb);
    }
}
