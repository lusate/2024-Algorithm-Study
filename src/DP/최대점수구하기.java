package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기 {
    /**
     * 냅색 알고리즘 문제를 풀 때는 문제 종류나 동전, 보석의 종류가 무한정으로 있다고 한다면
     * 앞에서부터 j가 움직이면 됩니다.
     * 하지만 개수 제한이 있는 경우라면 뒤에서부터 움직여야 중복이 발생하지 않습니다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());

            for (int j = m; j >= pt; j--) {
                dp[j] = Math.max(dp[j], dp[j - pt] + ps);
            }
        }

        System.out.println(dp[m]);
    }
}
/*
5 20
10 5
25 12
15 8
6 3
7 4
 */