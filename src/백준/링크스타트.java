package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 링크스타트 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] ab;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static int getResult() {
        int start = 0;
        int link = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                if(visit[i] && visit[j]) start += ab[i][j];
                if(!visit[i] && !visit[j]) link += ab[i][j];
            }
        }
        return Math.abs(start-link);
    }

    public static void dfs(int L, int s) {
        if(L == N/2){
            // 각 팀의 최솟값을 구해야 함.
            answer = Math.min(getResult(), answer);
            return;
        }

        for (int i = s; i <= N; i++) {
            visit[i] = true;
            dfs(L + 1, i + 1);
            visit[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ab = new int[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                ab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 1차원 배열이라면 어차피 1씩 더해서 갈 거기 때문에 for문 필요없음.
         * L은 현재 선택한 인원스 카운트
         * i는 시작점 -> N까지
         */
        dfs(0, 1);
        System.out.println(answer); //
    }
}
