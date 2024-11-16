package 이코테.DP;

public class 못생긴수 {
    public int solution(int n) {
        int answer = 0;
        // dp는 2,3,5를 약수로 가지는 합성수
        int[] dp = new int[1001];
        dp[0] = 1;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int a = 2, b = 3, c = 5;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(a, Math.min(b, c));

            // dp는 a,b,c 중에서 최솟값이 된 경우에서 2,3,5 를 곱해야 함
            // 그 최솟값이 됐을 경우
            if (dp[i] == a) {
                idx1++;
                a = dp[idx1] * 2;
            }
            if (dp[i] == b) {
                idx2++;
                b = dp[idx2] * 3;
            }
            if (dp[i] == c) {
                idx3++;
                c = dp[idx3] * 5;
            }
            /*
            i = 1 -> dp[1] = 2
            i = 2 -> dp[2] = 3
            i = 3 -> dp[3] = 4
            i = 4 -> dp[4] = 5
            i = 5 -> dp[5] = 6
            i = 6 -> dp[6] = 8
            i = 7 -> dp[8] = 9
             */

        }
        answer = dp[n - 1];

        return answer;
    }
    public static void main(String[] args) {
        못생긴수 T = new 못생긴수();
        System.out.println(T.solution(10)); // 12
        System.out.println(T.solution(4)); // 4
    }
}
