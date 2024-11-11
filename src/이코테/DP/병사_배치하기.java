package 이코테.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이 문제처럼 하나의 for문으로 앞 뒤 조건을 가려서 하려고 할 경우 배열 크기가 문제일 때
 * 반드시 이중 for문으로 하는 LIS 알고리즘 생각해보기
 */
public class 병사_배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1]; // 남아 있는 병사 수
        Arrays.fill(dp, 1); // 병사가 최소 한 명은 존재하기 때문에 1로 초기화
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) { // LIS 알고리즘
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) { // 앞에 있는 값들이 모두 뒤보다 커야 함
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // dp 내에서 최대값 -> 현재 남아 있는 경우의 병사 수
            max = Math.max(max , dp[i]);
        }
        System.out.println(n - max);
    }
}
