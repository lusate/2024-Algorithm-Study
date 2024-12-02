package 이코테.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1번 N번까지의 헛간 존재
 * 술래는 항상 1번에서 출발, 총 M개의 양방향 통로가 존재
 * 최단 거리는 가장 먼 헛간이 가장 안전하고 최단 거리는 지나야 하는 길의 최소 개수
 * 출력은 숨어야 하는 헛간 번호, 그 헛간까지의 거리, 헛간과 같은 거리를 갖는 헛간의 개수를 출력
 */
public class 숨바꼭질 {
    static ArrayList<Node>[] graph;
    static int[] dis;
    static final int INF = (int) 1e9;

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(dis[now] < nowCost) continue;
            for (Node ob : graph[now]) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Node(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }


    public int[] solution(int n, int m, int[][] arr) {
        graph = new ArrayList[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            graph[a].add(new Node(b, 1));
            graph[b].add(new Node(a, 1));
        }
        Arrays.fill(dis, INF);
        dijkstra(1);

        int number = 0, distance = 0, cnt = 0;
        /*for (int i = 1; i <= n; i++) {
            System.out.print(dis[i] + " ");
            // 1000000000 0 1 1 2 2 2
        }*/


        int[] answer = new int[3];
        for (int i = 1; i <= n; i++) {
            if (distance < dis[i]) {
                number = i;
                distance = dis[i];
                cnt = 1; // 새로운 최대 거리 발견하면 카운트를 초기화
            } else if (dis[i] == distance) {
                cnt++;
            }
        }

        answer[0] = number;
        answer[1] = distance;
        answer[2] = cnt;
        return answer;
    }
    public static void main(String[] args) {
        숨바꼭질 T = new 숨바꼭질();
        System.out.println(Arrays.toString(T.solution(6, 7, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2},
                {2, 4}, {5, 2}})));
    }
}

/*
4 2 3
 */