package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕가게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         * 가격인 m에서 x100을 하는데 곱하기 100을 하면 4.12 -> 412가 되지 않고
         * 부동 소수점에는 약간의 오류가 있기 때문에 411.9999~ 이런 식으로 나올 가능성이 있습니다
         * 그래서 바로 int 로 형변환 해버리면 값이 411이 됩니다.
         * 따라서 반올림(Math.round)을 통해 정확하게 값이 나오도록 해줍니다.
         */
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            if(n==0 && m==0) break;

            int[] dy = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

                for (int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - p] + c);
                }
            }

            System.out.println(dy[m]);
        }
    }
}
