package 이코테.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정확한_순위 {
    static int INF = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 학생들의 성적을 비교한 결과 성적 순위를 정확히 알 수 있는 학생이 모두 몇명인지 계산
        // 성적 순위를 정확히 알기 위해서는 모든 학생과 점수 비교가 가능해야 함
        // 그래서 전체 노드 수인 n에 도달하면 answer를 +
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 한명한명을 다 비교하기 위해서 cnt를 여기서 초기화
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF) {
                    cnt++;
                }
            }

            if (cnt == n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

/* 입력 예시
6 6
1 5
3 4
4 2
4 6
5 2
5 4

출력 예시 : 1
 */