package 이코테.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

/**
 * 그래프처럼 보이지만 실제론 BFS처럼 이동이 필요.
 * 2차원 배열 arr이 각각의 칸을 지나기 위한 비용으로 있기 때문에
 * 클래스로 하나 둬서 PriorityQueue에 맞게 먼저 처리될 비용을 둬서 해도 되지만 배열을 안에 넣어서 하는 방법을 선택해봄.
 */
public class 화성탐사 {
    static final int INF = (int) 1e9;
    static int[][] dis;
//    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<int[]> pq;
    public void dijkstra(int n, int[][] graph) {
        pq.offer(new int[]{0, 0, graph[0][0]});
        dis[0][0] = graph[0][0];

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            for(int k=0; k<4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                int newCost = graph[nx][ny] + tmp[2];
                if(dis[tmp[0]][tmp[1]] < tmp[2]) continue;
                if(newCost < dis[nx][ny]){
                    dis[nx][ny] = newCost;
                    pq.offer(new int[]{nx, ny, newCost});
                }
            }
        }
    }
    public int solution(int n, int[][] graph) {
        // PriorityQueue 이기 때문에 어느 것을 기준으로 오름차순 할 것인지 정의가 있어야 함.
        // 람다 표현식으로 a[2] (각 배열이 나타내는 비용)기준으로 낮은 비용을 가진 노드가 먼저 처리됨.
        pq = new PriorityQueue<>(comparingInt(a -> a[2]));
        dis = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], INF);
        }

        dijkstra(n, graph);
        return dis[n - 1][n - 1];
    }
    public static void main(String[] args) {
        화성탐사 T = new 화성탐사();
//        System.out.println(T.solution(3, new int[][]{{5, 5, 4}, {3, 9, 1}, {3, 2, 7}}));
        System.out.println(T.solution(5, new int[][]{{3, 7, 2, 0, 1}, {2, 8, 0, 9, 1}, {1, 2, 1, 8, 1},
                {9, 8, 9, 2, 0}, {3, 6, 5, 1, 5}}));
    }
}

/*
입력 예시 1
3
5 5 4
3 9 1
3 2 7

출력 예시 1
20

입력 예시 2
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5

19

 */