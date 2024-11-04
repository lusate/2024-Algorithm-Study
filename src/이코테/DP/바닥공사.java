package 이코테.DP;

public class 바닥공사 {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[1001];

        dp[1] = 1; // 바닥을 채우는 방법의 수
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
            // dp[i - 1]는 길이 i-1인 바닥에 1x2 타일을 세로로 놓는 경우
            // dp[i - 2]는 길이 i-2인 바닥에 1x2 타일을 가로로 놓는 경우, 2x2 를 놓는 경우
        }

        answer = dp[n];
        return answer;
    }
    public static void main(String[] args) {
        바닥공사 T = new 바닥공사();
        System.out.println(T.solution(3));
    }
}
