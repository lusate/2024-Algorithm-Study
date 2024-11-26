package 이코테.그래프;

import java.util.Arrays;

/**
 * A에서 출발해서 X번 회사에 가서 물건을 판매하기 전에 먼저 소개팅 상대의 회사를 찾아감
 * 1번 회사에서 출발해서 K번 회사를 방문한 뒤에 X번 회사로 감
 * 특정 지점인 1번에서 출발을 해서 다익스트라를 사용해야 할 것 같지만 다음 지점(소개팅 지점)이 또 존재하기 때문에 플로이드를 사용
 */
public class 미래도시 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 거쳐 갈 노드(X), 최종 목적지 노드(K)

    public int solution(int N, int M, int[][] arr, int X, int K) {
        int[][] graph = new int[N+1][N+1];
        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < M; i++) {
            // A와 B가 서로에게 가는 비용은 1이라고 설정
            int a = arr[i][0];
            int b = arr[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int answer = graph[1][K] + graph[K][X];
        if (answer >= INF) answer = -1;

        return answer;
    }

    public static void main(String[] args) {
        미래도시 T = new 미래도시();
        System.out.println(T.solution(5, 7, new int[][]{{1,2}, {1,3}, {1,4},{2,4}, {3,4}, {3,5},
                {4,5}}, 4, 5));
//        System.out.println(T.solution(4, 2, new int[][]{{1, 3}, {2, 4}}, 3, 4));
    }
}
