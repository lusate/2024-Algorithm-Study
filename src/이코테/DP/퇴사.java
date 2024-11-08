package 이코테.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주의할 점
 * 해달 날짜가 된다고 해서 이익이 늘어나는 것이 아님
 * ex) 상담 날짜가 1일 -> 10 이익을 얻어야 하는데 dp에서는 얻지 않음.
 * dp는 해당 3일이 지나야 얻는 것 -> 4일이 돼야 10이 됨.
 */
public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] day = new int[n];
        int[] benefit = new int[n];
        int[] dp = new int[n + 1]; // 상담이 끝나는 날은 그 다음날이기 때문에

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            benefit[i] = Integer.parseInt(st.nextToken());
        }

        // 최대한 많은 상담으로 최대 이익을 구하기
        for (int i = 0; i < n; i++) {
            if (i + day[i] <= n) { // 현재 상담 날짜 시 최대 이익
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + benefit[i]);
            }
            // 이전 날짜의 최대 이익을 현재 날짜에 반영, 상담 선택하지 않을 경우도 생각
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            System.out.println("i = " + i + ", dp = " + dp[i]);
        }

        // n일까지의 최대 이익 출력
        System.out.println(dp[n]); // n일까지의 최대 이익 출력
    }
}


/*
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
 */