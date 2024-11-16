package 이코테.DP;

public class 편집거리 {
    public int solution(String s1, String s2) {
        int answer = 0;
        // cat -> cut으로 만들 때 삽입, 삭제, 교체할 때의 연산 수
        // 배열 크기를 조절 불가능 -> dp를 2차원으로
        // 행일 때는 삽입, 열일 때는 삭제, 애각선이면 교체 -> 이렇게 연산
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=s2.length(); j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 같은 문자면 이전 것 그대로 (모든 연산 방법 다 필요 없음)
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // "c" , "cu" 인 경우라면 삽입이므로 연산 +1
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

            }
        }
        answer = dp[s1.length()][s2.length()];


        return answer;
    }
    public static void main(String[] args) {
        편집거리 T = new 편집거리();
        System.out.println(T.solution("cat", "cut")); // 1
        System.out.println(T.solution("sunday", "saturday")); // 3
    }
}
