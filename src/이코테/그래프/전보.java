package 이코테.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 도시의 개수, 통로의 개수, 메시지를 보내고자 하는 도시 C
 * C라는 도시에서 최대한 많은 도시로 메시지를 보내도록 함
 * C에서 보낸 메시지를 받게 되는 도시의 개수와 도시들이 모두 메시지를 받는 데까지 걸리는 시간
 * C에서만 출발하기 때문에 다익스트라를 사용
 */
/*class Node implements Comparable<Node> {
    int vex, cost;
    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}*/
public class 전보 {
    static final int INF = (int) 1e9;
    static int[] dis;
    static PriorityQueue<Node> pq;
    ArrayList<Node>[] graph;

    public void dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // C에서 시작
        dis[start] = 0;

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            // 현재 노드 now 까지의 비용 nowCost 가 이미 기록된 최단 거리 dis[now] 보다 크면 무시하고 다음 노드로 넘어감
            if(dis[now] < nowCost) continue;
            for(Node ob : graph[now]) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Node(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public int[] solution(int N, int M, int C, int[][] arr) {
        dis = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int z = arr[i][2];

            // x번 노드에서 y번 노드로 가는 비용이 z
            graph[x].add(new Node(y, z));
        }
        Arrays.fill(dis, INF);

        dijkstra(C);

        int count = 0; // C에서 보낸 메시지를 받게 되는 도시의 개수
        int time = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
//            System.out.println("dis[i] = " + dis[i]);
            // 도달할 수 있는 도시라면 INF가 아님
            if (dis[i] != INF) {
                count += 1;
                // 도시들이 모두 메시지를 받는 데까지 걸리는 시간
                time = Math.max(time, dis[i]);
            }
        }

        int[] answer = new int[2];
        answer[0] = count - 1; // 시작 노드는 제외
        answer[1] = time;

        return answer;
    }
    public static void main(String[] args) {
        전보 T = new 전보();
        System.out.println(Arrays.toString(T.solution(3, 2, 1, new int[][]{{1, 2, 4}, {1, 3, 2}})));
    }
}
