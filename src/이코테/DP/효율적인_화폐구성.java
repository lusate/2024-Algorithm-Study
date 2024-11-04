package 이코테.DP;

import java.util.Arrays;

public class 효율적인_화폐구성 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int[] dp = new int[m+1];
        Arrays.fill(dp, 10001); // arr로 만들 수 없는 숫자를 만들기 위함

        // j - arr[i]는 현재 금액 j에서 화폐 단위 arr[i]를 빼서 얻은 금액. 즉 arr[i]를 사용하기 전의 금액
        // dp[j - arr[i]] 는 금액 j-arr[i]를 만들기 위해 필요한 최소 화폐 개수
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (dp[j - arr[i]] != 10001) { // 10001 이 아니라면 이 금액을 만들 수 있음
                    // arr[i]를 추가하기 전에 j - arr[i] 금액을 만들 수 있는 방법이 존재
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
                System.out.println("dp[j] = " + j + " : " + dp[j]);
            }
        }

        if (dp[m] == 10001) {
            answer = -1;
        } else answer = dp[m];

        return answer;
    }
    public static void main(String[] args) {
        효율적인_화폐구성 T = new 효율적인_화폐구성();
        System.out.println(T.solution(2, 15, new int[]{2, 3}));
//        System.out.println(T.solution(3, 4, new int[]{3, 5, 7}));
    }
}
